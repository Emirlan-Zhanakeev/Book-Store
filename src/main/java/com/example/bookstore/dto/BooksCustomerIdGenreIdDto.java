package com.example.bookstore.dto;


import lombok.Data;

@Data
public class BooksCustomerIdGenreIdDto {
    private Long id;
    private String name;
    private String author;
    private int price;
    private Long customer_id;
    private Long genre_id;
    private Long sale_id;
    private Long seller_id;
}
