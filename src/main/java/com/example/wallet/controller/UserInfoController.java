package com.example.wallet.controller;

import com.example.wallet.dto.UserInfoDto;
import com.example.wallet.mapper.UserInfoMapper;
import com.example.wallet.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.wallet.repository.UserInfoRepo;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@Service
public class UserInfoController {


    @Autowired
    private UserInfoRepo userInfoRepo;


    /*
    Post to get user info
     */
    @PostMapping(value = "/user/info")
    public UserInfo getUserInfo(@RequestBody UserInfoDto userInfo) {
        UserInfo user = userInfoRepo.findByName(userInfo.getName());
        user.setRequest_uuid(userInfo.getRequest_uuid());
        userInfoRepo.save(user);
        return user;
    }

    @GetMapping("/user/info")
    public ResponseEntity<List<UserInfo>> getUserInfo() {
        return ResponseEntity.ok().body(userInfoRepo.findAll());
    }

}
