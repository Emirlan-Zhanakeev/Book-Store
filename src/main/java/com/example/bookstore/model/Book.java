package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Books")
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String author;
    private int price;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;

}