package com.example.bookstore.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Sale {

    @Id
    private Long id;
    private String name;
    private int percentage;



}
