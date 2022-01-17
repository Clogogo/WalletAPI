package com.example.wallet.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserTransactionDto implements Serializable {
    private final Long id;
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
    private final Boolean is_free;
    private final Boolean is_aggregate;
    private final String game_code;
    private final String currency;
    private final String bet;
    private final Integer win_amount;
    private final Integer new_balance;
}
