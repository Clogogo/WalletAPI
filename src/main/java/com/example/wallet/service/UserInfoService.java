package com.example.wallet.service;


import com.example.wallet.Utilities.Status;
import com.example.wallet.dto.UserInfoDto;
import com.example.wallet.dto.WalletTransactionDto;
import com.example.wallet.model.UserInfo;
import com.example.wallet.model.WalletTransaction;
import com.example.wallet.repository.TransactionRepo;
import com.example.wallet.repository.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepo userInfoRepo;

    @Autowired
    private TransactionRepo transactionRepo;


    /*


     */
    public UserInfo returnUserInfo(UserInfoDto userInfoDto) {
        try {
            UserInfo user = userInfoRepo.findByUser(userInfoDto.getUser());

            if (!userInfoDto.getRequest_uuid().equals(user.getRequest_uuid())) {
                return new UserInfo(Status.RS_ERROR_WRONG_SYNTAX);
            }
            user.setRequest_uuid(userInfoDto.getRequest_uuid());
            return userInfoRepo.save(user);
        } catch (Exception ex) {
            return new UserInfo(Status.RS_ERROR_USER_INVALID);
        }
    }

    public WalletTransaction returnBalance(WalletTransactionDto transaction) {
        try {

            WalletTransaction user = transactionRepo.findByUser(transaction.getUser());

            if (!transaction.getUser().equals(user.getUser())) {
                return new WalletTransaction(Status.RS_ERROR_USER_INVALID);
            } else if (!user.getToken().equals(transaction.getToken()) || transaction.getToken().isEmpty()) {
                return new WalletTransaction(Status.RS_ERROR_INVALID_TOKEN);
            } else if (transaction.getRequest_uuid().isEmpty() || !transaction.getRequest_uuid().equals(user.getRequest_uuid())) {
                return new WalletTransaction(Status.RS_ERROR_WRONG_SYNTAX);
            }
            user.setRequest_uuid(transaction.getRequest_uuid());
            user.setGame_code(transaction.getGame_code());
            transactionRepo.save(user);
            return transactionRepo.findByUser(transaction.getUser());
        } catch (Exception ex) {
            return new WalletTransaction(Status.RS_ERROR_USER_INVALID);
        }
    }

    public WalletTransaction processBet(WalletTransactionDto transaction) {

        try {
            WalletTransaction user = transactionRepo.findByUser(transaction.getUser());
            Status status = validateTransactionCheck(transaction, user);
            if (status.equals(Status.RS_OK)) {
                user.setPreviousBalance(user.getBalance());
                user.setBalance(user.getBalance() - transaction.getAmount());
                return transactionRepo.save(user);
            } else {
                transactionRepo.save(user);
                return new WalletTransaction(status);
            }
        } catch (Exception ex) {
            return new WalletTransaction(Status.RS_ERROR_USER_INVALID);
        }

    }

    public WalletTransaction processRollback(WalletTransactionDto transaction) {
        try {
            WalletTransaction user = transactionRepo.findByUser(transaction.getUser());

            Status status = validateTransactionCheck(transaction, user);
            if (status.equals(Status.RS_ERROR_DUPLICATE_TRANSACTION)) {
                user.setBalance(user.getPreviousBalance());
                user.setStatus(String.valueOf(Status.RS_OK));
                return transactionRepo.save(user);
            } else {
                transactionRepo.save(user);
                return new WalletTransaction(status);
            }

        } catch (Exception ex) {
            return new WalletTransaction(Status.RS_ERROR_USER_INVALID);
        }

    }

    public WalletTransaction processWin(WalletTransactionDto transaction) {
        try {
            WalletTransaction user = transactionRepo.findByUser(transaction.getUser());
            Status status = validateTransactionCheck(transaction, user);
            if (status.equals(Status.RS_OK)) {
                if (user.getReference_transaction_uuid().equals(transaction.getReference_transaction_uuid())) {
                    user.setPreviousBalance(user.getBalance());
                    user.setBalance(user.getBalance() + transaction.getAmount());
                    return transactionRepo.save(user);
                }
            } else {
                transactionRepo.save(user);
                return new WalletTransaction(status);
            }
            return transactionRepo.findByUser(transaction.getUser());
        } catch (Exception ex) {
            return new WalletTransaction(Status.RS_ERROR_USER_INVALID);
        }

    }


    public Status validateTransactionCheck(WalletTransactionDto info, WalletTransaction user) {

        if (!info.getRequest_uuid().equals(user.getRequest_uuid())) {
            return Status.RS_ERROR_WRONG_SYNTAX;
        } else if (!info.getToken().equals(user.getToken())) {
            return Status.RS_ERROR_INVALID_TOKEN;
        } else if (info.getTransaction_uuid().isEmpty()) {
            return Status.RS_ERROR_TRANSACTION_DOES_NOT_EXIST;
        } else if (user.getTransaction_uuid().equals(info.getTransaction_uuid())) {
            return Status.RS_ERROR_DUPLICATE_TRANSACTION;
        } else if (user.getBalance() < info.getAmount()) {
            return Status.RS_ERROR_NOT_ENOUGH_MONEY;
        } else {
            return Status.RS_OK;
        }
    }


}
