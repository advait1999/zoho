package com.zohocrm.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeadDto {


    private String lid;

    private String firstname;

    private String lastname;

    private String email;

    private long mobile;

    private String leadType;

    private String address;

    private String designation;

    private String company;

    private String note;


}
