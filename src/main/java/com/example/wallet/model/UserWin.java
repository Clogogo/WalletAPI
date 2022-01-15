package com.example.wallet.model;

/*
Called when the User wins (credit).
Operator is expected to increase player's balance by amount and return new balance.
reference_transaction_uuid show to which bet this win is related.
Each win has transaction_uuid which is unique identifier of this transaction.
Before any altering of User's balance, Operator has to check that win wasn't processed before.
Retry Policy: In case of network fail (HTTP 502, timeout, nxdomain, etc.)
we will retry 3 times with 1 sec of timeout. The rest of retry logic is left to provider’s RGS: the retries may continue indefinitely or the bet may be rolled back, and the money returned back to user.



{
  "user": "Jimm123",
  "status": "RS_OK",
  "request_uuid": "583c985f-fee6-4c0e-bbf5-308aad6265af",
  "currency": "USD",
  "balance": 100500
}

 */
public class UserWin {

    //john12345
    private String username;

    //16d2dcfe-b89e-11e7-854a-58404eea6d16
    private String transaction_uuid;

    //41ecc3ad-b181-4235-bf9d-acf0a7ad9730
    private String supplier_transaction_id;

    //55b7518e-b89e-11e7-81be-58404eea6d16
    private String token;

    //cg_45141
    private String supplier_user;

    //true
    private Boolean round_closed;

    //rNEMwgzJAOZ6eR3V
    //nullable true
    private String round;

    //a28f93f2-98c5-41f7-8fbb-967985acf8fe
    private String reward_uuid;

    //583c985f-fee6-4c0e-bbf5-308aad6265af
    private String request_uuid;

    //16d2dcfe-b89e-11e7-854a-58404eea6d16
    private String reference_transaction_uuid;


    //false
    private Boolean is_free;

    //false
    private Boolean is_aggregate;

    //  "game_code": "clt_dragonrising",
    private String game_code;

    //Eur
    private String currency;

    //value of bet
    //nullable true
    private String bet;


    //1000500
    private Integer win_amount;


    //win_amount + balance
    private Integer new_balance;






}
