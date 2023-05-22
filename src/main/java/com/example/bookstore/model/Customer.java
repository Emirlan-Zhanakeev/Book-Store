package com.example.bookstore.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private int age;

}
