package com.example.wallet.controller;


import com.example.wallet.dto.BalanceDto;
import com.example.wallet.dto.UserInfoDto;
import com.example.wallet.dto.WalletTransactionDto;
import com.example.wallet.mapper.BalanceMapper;
import com.example.wallet.mapper.UserInfoMapper;
import com.example.wallet.model.UserBalance;
import com.example.wallet.model.UserInfo;
import com.example.wallet.model.WalletTransaction;
import com.example.wallet.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@NoArgsConstructor
@AllArgsConstructor
@RestController
@Service
public class UserController {



    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    BalanceMapper balanceMapper;

    UserBalance userBalance;

    @Autowired
    UserService userService;


    /*
    Save post request and return user info
     */
    @PostMapping(value = "/user/info")
    public UserInfoDto returnUserInfo(@RequestBody UserInfoDto userInfo) {
        UserInfo user = userService.returnUserInfo(userInfo);
        return userInfoMapper.toDto(user);
    }

    /*
    Save post request and return balance info
     */
    @PostMapping("/user/balance")
    public BalanceDto returnUserBalance(@RequestBody WalletTransactionDto info) {
        WalletTransaction user = userService.returnBalance(info);
        return balanceMapper.toBalanceDto(user);
    }


    @PostMapping("/transaction/win")
    public BalanceDto processUserWin(@RequestBody WalletTransactionDto transaction) {
        WalletTransaction user = userService.processWin(transaction);
        return balanceMapper.toBalanceDto(user);
    }


    @PostMapping("/transaction/rollback")
    public BalanceDto processRollback(@RequestBody WalletTransactionDto transaction) {
        WalletTransaction user = userService.processRollback(transaction);
        return balanceMapper.toBalanceDto(user);

    }


    @PostMapping("/transaction/bet")
    public BalanceDto processBet(@RequestBody WalletTransactionDto transaction) {
        WalletTransaction user = userService.processBet(transaction);
        return balanceMapper.toBalanceDto(user);
    }


}
