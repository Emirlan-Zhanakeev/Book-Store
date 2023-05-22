package com.example.bookstore.dto;


import lombok.Data;


import java.time.LocalDateTime;

@Data
public class SellerDto {
    private Long id;
    private String name;
    private LocalDateTime firstDay;
    private Long customer_id;

}
