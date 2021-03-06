package com.example.wallet.repository;

import com.example.wallet.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {
    UserInfo findByUser(String username);
}
