package com.example.bookstore.dto;

import lombok.Data;

@Data
public class BookPurchaseDto {
    private Long bookId;
    private String bookName;
    private int price;
    private Long id;
    private String name;
}
