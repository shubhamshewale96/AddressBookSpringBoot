package com.example.Model;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "AddressBook")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String city;

    @Column(name = "mobile_no")
    private long mobileNo;

}
