package com.example.wallet.dto;

import lombok.Data;


@Data
public class WalletTransactionDto {

    private final String user;
    private final String transaction_uuid;
    private final String supplier_transaction_id;
    private final String token;
    private final String supplier_user;
    private final Boolean round_closed;
    private final String round;
    private final String reward_uuid;
    private final String request_uuid;
    private final String reference_transaction_uuid;
    private final String status;
    private final Boolean is_free;
    private final Boolean is_aggregated;
    private final String game_code;
    private final String currency;
    private final String bet;
    private final Integer amount;
    private final Integer balance;
    private final Integer previousBalance;


}
