package com.example.wallet.model;

/*
Called when there is need to roll back the effect of the referenced transaction. Operator is expected to find referenced transaction,
roll back its effects and return the player's new balance.


  "user": "Jimm123",
  "status": "RS_OK",
  "request_uuid": "583c985f-fee6-4c0e-bbf5-308aad6265af",
  "currency": "USD",
  "balance": 100500

 */
public class UserRollback {
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

    //  "game_code": "clt_dragonrising",
    private String game_code;

}
