package com.example.wallet.model;


import com.example.wallet.Utilities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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


//    @Column(name = "token", nullable = false)
//    private String token = new GenerateToken().getToken();

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

    @Column(name = "bet_active", nullable = false)
    private Boolean betActive;

    public WalletTransaction(Status rsErrorUserInvalid) {
        this.status = String.valueOf(rsErrorUserInvalid);
    }

}
