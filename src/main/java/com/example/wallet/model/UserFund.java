package com.example.wallet.model;


import com.example.wallet.Utilities.GenerateToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "finance")
public class UserFund {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String user;

    @Column(name = "token", nullable = false)
    private String token = new GenerateToken().getToken();

    //"583c985f-fee6-4c0e-bbf5-308aad6265af"
    @Column(name = "request_id", nullable = false)
    private String request_uuid;

    @Column(name = "game_code", nullable = false)
    private String game_code;

    @Column(name = "currency", nullable = false)
    private String Currency;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "balance", nullable = false)
    private String balance;

}
