package com.example.bookstore.service.impl;

import com.example.bookstore.model.Sale;
import com.example.bookstore.repository.SaleRepository;
import com.example.bookstore.service.SaleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Sale updateSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public boolean deleteSale(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isPresent()) {
            saleRepository.delete(sale.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Sale> getAllSale() {
        return saleRepository.findAll();
    }

    @Override
    public Optional<Sale> getSaleById(Long id) {
        return saleRepository.findById(id);
    }
}
