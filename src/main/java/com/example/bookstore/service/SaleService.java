package com.example.bookstore.service;


import com.example.bookstore.model.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleService {
    Sale saveSale(Sale sale);
    Sale updateSale(Sale sale);
    boolean deleteSale(Long id);
    List<Sale> getAllSale();
    Optional<Sale> getSaleById(Long id);

}
