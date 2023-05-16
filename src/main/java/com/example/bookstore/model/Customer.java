package com.example.bookstore.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private int age;
    private

//    @OneToMany(mappedBy = "customer")
//    private List<Book> books;

}
