package com.example.wallet.dto;

import lombok.Data;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;

@Data
public class UserInfoDto {

    @NotBlank(message = "The name is required.")
    private final String user;

    @NotBlank(message = "The status is required.")
    private final String status;

    @NotBlank(message = "The request_id is required.")
    private final String request_uuid;

    @NotBlank(message = "The country is required.")
    private final String country;

    @NotBlank(message = "The jurisdiction is required.")
    private final String jurisdiction;

    @NotBlank(message = "The sub_partner_id is required.")
    private final String sub_partner_id;

//    @NotBlank(message = "The birth_date is required.")
    private final LocalDate birth_date;

//    @NotBlank(message = "The registration_date is required.")
    private final LocalDate registration_date;

    @NotBlank(message = "The tags is required.")
    private final String tags;

    @NotBlank(message = "The sex is required.")
    private final String sex;

    @NotBlank(message = "The affiliate_id is required.")
    private final String affiliate_id;

}
