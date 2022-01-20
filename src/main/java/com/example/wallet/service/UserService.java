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
public class UserService {

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

        WalletTransaction user = transactionRepo.findByUser(transaction.getUser());

        if (!transaction.getUser().equals(user.getUser())) {
            return new WalletTransaction(Status.RS_ERROR_USER_INVALID);
        } else if (!user.getToken().equals(transaction.getToken()) || transaction.getToken().isEmpty()) {
            return new WalletTransaction(Status.RS_ERROR_INVALID_TOKEN);
        } else if (transaction.getRequest_uuid().isEmpty() || !transaction.getRequest_uuid().equals(user.getRequest_uuid())) {
            return new WalletTransaction(Status.RS_ERROR_TRANSACTION_DOES_NOT_EXIST);
        }
        user.setRequest_uuid(transaction.getRequest_uuid());
        user.setGame_code(transaction.getGame_code());
        return transactionRepo.save(user);
    }

    public WalletTransaction processBet(WalletTransactionDto transaction) {

        WalletTransaction user = transactionRepo.findByUser(transaction.getUser());

        if (user.getBalance() <= transaction.getAmount()) {
            return new WalletTransaction(Status.RS_ERROR_NOT_ENOUGH_MONEY);
        }
        if (user.getTransaction_uuid().equals(transaction.getTransaction_uuid())) {
            return new WalletTransaction(Status.RS_ERROR_DUPLICATE_TRANSACTION);
        }
        user.setUser(transaction.getUser());
        user.setPreviousBalance(user.getBalance());
        user.setBalance(user.getBalance() - transaction.getAmount());
        user.setRound_closed(false);
        user.setGame_code(transaction.getGame_code());
        user.setTransaction_uuid(transaction.getTransaction_uuid());
        user.setReference_transaction_uuid(transaction.getTransaction_uuid());
        user.setTransaction_uuid(transaction.getTransaction_uuid());
        return transactionRepo.save(user);

    }

    public WalletTransaction processRollback(WalletTransactionDto transaction) {


        WalletTransaction user = transactionRepo.findNameById(1L);
        if (user.getToken().equals(transaction.getToken()) &&
                user.getReference_transaction_uuid().equals(transaction.getReference_transaction_uuid())) {
            user.setBalance(user.getPreviousBalance());
            user.setRound_closed(true);
            return transactionRepo.save(user);
        } else {
            return new WalletTransaction(Status.RS_ERROR_UNKNOWN);
        }

    }


    public WalletTransaction processWin(WalletTransactionDto transaction) {

        WalletTransaction user = transactionRepo.findNameById(1L);
        Status status = validateTransactionCheck(transaction, user);
        if (status.equals(Status.RS_OK) && user.getTransaction_uuid().equals(user.getReference_transaction_uuid())) {
            user.setPreviousBalance(user.getBalance());
            user.setBalance(user.getBalance() + transaction.getAmount());
            user.setStatus(String.valueOf(status));
            user.setReference_transaction_uuid(transaction.getTransaction_uuid());
            user.setRound_closed(true);
            return transactionRepo.save(user);
        } else {
            return new WalletTransaction(status);
        }
    }


    public Status validateTransactionCheck(WalletTransactionDto info, WalletTransaction user) {

        if (!info.getRequest_uuid().equals(user.getRequest_uuid())) {
            return Status.RS_ERROR_WRONG_SYNTAX;
        } else if (!info.getToken().equals(user.getToken())) {
            return Status.RS_ERROR_INVALID_TOKEN;
        } else if (info.getTransaction_uuid().isEmpty()) {
            return Status.RS_ERROR_TRANSACTION_DOES_NOT_EXIST;
        } else if (user.getRound_closed().equals(true)) {
            return Status.RS_ERROR_DUPLICATE_TRANSACTION;
        } else if (!user.getCurrency().equals(info.getCurrency())) {
            return Status.RS_ERROR_INVALID_GAMERS_ERROR_WRONG_CURRENCY;
        } else {
            return Status.RS_OK;
        }
    }


}
