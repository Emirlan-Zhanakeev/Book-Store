package com.example.bookstore.dto;


import lombok.Data;

@Data
public class BooksAndCustomerIdDto {
    private Long id;
    private String name;
    private String author;
    private int price;
    private Long customer_id;
}
