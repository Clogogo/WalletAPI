package com.example.wallet.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class WalletTransaction {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //john12345
    @Column(name = "name", nullable = false)
    private String user;

    //16d2dcfe-b89e-11e7-854a-58404eea6d16
    @Column(name = "trans_id", nullable = false)
    private String transaction_uuid;

    //41ecc3ad-b181-4235-bf9d-acf0a7ad9730
    @Column(name = "sup_trans_id", nullable = false)
    private String supplier_transaction_id;

    //55b7518e-b89e-11e7-81be-58404eea6d16
    @Column(name = "token", nullable = false)
    private String token;

    //cg_45141
    @Column(name = "sup_user", nullable = false)
    private String supplier_user;

    //true
    @Column(name = "round_closed", nullable = false)
    private Boolean round_closed;

    //rNEMwgzJAOZ6eR3V
    //nullable true
    @Column(name = "round", nullable = false)
    private String round;

    //a28f93f2-98c5-41f7-8fbb-967985acf8fe
    @Column(name = "reward_id", nullable = false)
    private String reward_uuid;

    //583c985f-fee6-4c0e-bbf5-308aad6265af
    @Column(name = "request_id", nullable = false)
    private String request_uuid;

    //16d2dcfe-b89e-11e7-854a-58404eea6d16
    @Column(name = "ref_trans_id", nullable = false)
    private String reference_transaction_uuid;

    @Column(name = "status", nullable = false)
    private String status;

    //false
    @Column(name = "is_free", nullable = false)
    private Boolean is_free;

    //false
    @Column(name = "is_aggregated", nullable = false)
    private Boolean is_aggregated;

    //  "game_code": "clt_dragonrising",
    @Column(name = "game_code", nullable = false)
    private String game_code;

    //Eur
    @Column(name = "currency", nullable = false)
    private String currency;

    //value of bet
    //nullable true
    @Column(name = "bet", nullable = false)
    private String bet;

    //1000500
    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "balance", nullable = false)
    private Integer balance;

    @Column(name = "pre_Balance", nullable = false)
    private Integer previousBalance;


//    //win_amount + balance
//    private Integer new_balance;
}
