package com.codegym.sign_up.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;


    private String lastName;


    private String phoneNumber;


    private int age;

    private String email;

}
