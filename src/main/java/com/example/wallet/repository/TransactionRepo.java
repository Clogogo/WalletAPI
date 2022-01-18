package com.example.wallet.repository;

import com.example.wallet.model.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<WalletTransaction, Long> {
    WalletTransaction findByUser(String user);
}
