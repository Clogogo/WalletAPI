package com.example.wallet.repository;

import com.example.wallet.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {

    UserInfo findByName(String username);
}
