package com.zohocrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leads")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Lead {

    @Id
    private String lid;

    @Column(name = "first_name", nullable = false)
    private String firstname;

    @Column(name = "last_name", nullable = false)
    private String lastname;
    @Column(name = "email", nullable = false,unique = true)
    private String email;
    @Column(name = "mobile", nullable = false,unique = true)
    private long mobile;
    @Column(name = "lead_type", nullable = false)
    private String leadType;
    @Column(name = "address")
    private String address;
    @Column(name = "designation")
    private String designation;
    @Column(name = "company")
    private String company;
    @Column(name = "note")
    private String note;


}
