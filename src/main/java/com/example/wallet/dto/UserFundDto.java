package com.example.wallet.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserFundDto {
    private final Long id;
    private final String user;
    private final String token;
    private final String request_uuid;
    private final String game_code;
    private final String Currency;
    private final String status;
    private final String balance;
}
