package com.example.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "userinfo")
public class UserInfo {

    //User/inf

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //userstring
    //minLength: 3
    //example: john12345
    //Unique User ID in the Operator’s system.
    @Column(name = "name", nullable = false)
    private String user;


    //    //example: CTS_SUCCESS
    //[ RS_OK, RS_NOTFOUND ]
    @Column(name = "status", nullable = false)
    private String status;

    //"583c985f-fee6-4c0e-bbf5-308aad6265af"
    @Column(name = "request_id", nullable = false)
    private String request_uuid;

    //FR
    @Column(name = "country", nullable = false)
    private String country;

    //MGA or Corcecea
    @Column(name = "jurisdiction", nullable = false)
    private String jurisdiction;

    //123_sub
    @Column(name = "partner_id", nullable = false)
    private String sub_partner_id;

    //1980-10-20
    @Column(name = "DOB", nullable = false)
    private LocalDate birth_date;

    //2010-10-20
    @Column(name = "ROB", nullable = false)
    private LocalDate registration_date;

    //"VIP", "Affiliate"
    @Column(name = "tags", nullable = false)
    private String tags;

    //male or female
    @Column(name = "sex", nullable = false)
    private String sex;

    //124_af
    @Column(name = "affiliate_id", nullable = false)
    private String affiliate_id;

}
