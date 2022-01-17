package com.example.wallet.repository;

import com.example.wallet.model.UserFund;
import com.example.wallet.model.UserWalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTransactionRepo extends JpaRepository<UserWalletTransaction, Long> {
    UserWalletTransaction findByUser(String user);
}
