package com.example.bookstore.dto;

import lombok.Data;


public interface BooksPurchaseDto {
    Long getBookId();
    String getBookName();
    int getPrice();
    Long getId();
    String getName();
}
