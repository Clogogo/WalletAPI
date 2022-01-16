package com.example.wallet.repository;

import com.example.wallet.model.UserFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFundRepo extends JpaRepository<UserFund, Long> {
    UserFund findByUser(String user);
}
