package com.example.bookstore.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Genre")
public class Genre {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;

}
