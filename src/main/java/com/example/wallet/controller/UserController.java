package com.example.wallet.controller;

import com.example.wallet.Utilities.Status;
import com.example.wallet.dto.UserFundDto;
import com.example.wallet.dto.UserInfoDto;
import com.example.wallet.model.UserFund;
import com.example.wallet.model.UserInfo;
import com.example.wallet.repository.UserFundRepo;
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
public class UserController {


    @Autowired
    private UserInfoRepo userInfoRepo;

    @Autowired
    private UserFundRepo userFundRepo;


    /*
    Save post request and return user info

     */
    @PostMapping(value = "/user/info")
    public UserInfo returnUserInfo(@RequestBody UserInfoDto userInfo) {

        UserInfo user = userInfoRepo.findByUser(userInfo.getUser());
        user.setRequest_uuid(userInfo.getRequest_uuid());
        userInfoRepo.save(user);
        return user;
    }

    @GetMapping("/user/info")
    public ResponseEntity<List<UserInfo>> getUserInfo() {
        return ResponseEntity.ok().body(userInfoRepo.findAll());
    }


    /*
    Save post request and return balance info

     */
    @PostMapping("/user/balance")
    public UserFund getUserInfo(@RequestBody UserFundDto info) {

        UserFund user = userFundRepo.findByUser(info.getUser());
        if (info.getToken().equals(user.getToken())) {
            user.setRequest_uuid(info.getRequest_uuid());
            user.setGame_code(info.getGame_code());
            userFundRepo.save(user);
        } else {
            user.setStatus(String.valueOf(Status.RS_ERROR_INVALID_TOKEN));
        }
        return user;

    }


//    @PostMapping("/transaction/win")
//    public





}
