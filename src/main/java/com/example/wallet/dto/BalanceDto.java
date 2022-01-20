package com.example.wallet.dto;

import lombok.Data;

@Data
public class BalanceDto {

    private final String user;
    private final String request_uuid;
    private final String status;
    private final String currency;
    private final Integer balance;

}
