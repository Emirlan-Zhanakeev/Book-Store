package com.example.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Seller {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private LocalDateTime firstDay;

    @OneToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
