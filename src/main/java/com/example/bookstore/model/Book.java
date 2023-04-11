package com.example.bookstore.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Philosophy")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private int price;

}