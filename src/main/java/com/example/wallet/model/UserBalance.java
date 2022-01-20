package com.example.wallet.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
public class UserBalance {


    @Column(name = "name", nullable = false)
    private String user;

    //"583c985f-fee6-4c0e-bbf5-308aad6265af"
    @Column(name = "request_id", nullable = false)
    private String request_uuid;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "balance", nullable = false)
    private Integer balance;

}
