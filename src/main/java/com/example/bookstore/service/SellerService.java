package com.example.bookstore.service;


import com.example.bookstore.dto.SellerDto;
import com.example.bookstore.model.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerService {
    Seller save(SellerDto sellerDto);
    Seller update(SellerDto sellerDto);
    boolean delete(Long id);
    List<Seller> getAll();
    Optional<Seller> findById(Long id);
}
