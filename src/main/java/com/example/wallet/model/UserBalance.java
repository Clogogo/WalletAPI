package com.example.wallet.model;



/*
Called when player's balance is needed. Operator is expected to return player's current balance.
Game id is provided to help Operator with player's activity statistics.
 */
public class UserBalance {

    private String financeName;

//EUR
    private String currency;

    //user token
    //maxlength
    //Operator's back end generates a token associated with the User, game,
    // his or her current currency and maybe other parameters depending on the Operator's preferences.
    // The token acts as an ID parameter for the game session.
    // It is important that the currency is not changed during the current game session.
    // If the User changes the currency or display unit,
    // the Operator's backend needs to generate a new token and re-open the game with new token.
    // In case of DEMO gameplay,
    // this parameter may be omitted.
    private String token;


//583c985f-fee6-4c0e-bbf5-308aad6265af
    private String request_uuid;

    //clt_dragonrising
    private String game_code;

    //Value amount in User wallet
    private Long balance;




}
