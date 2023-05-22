package com.example.bookstore.service.impl;


import com.example.bookstore.dto.SellerDto;
import com.example.bookstore.model.Customer;
import com.example.bookstore.model.Seller;
import com.example.bookstore.repository.SellerRepository;
import com.example.bookstore.service.SellerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final CustomerServiceImpl customerService;

    public SellerServiceImpl(SellerRepository sellerRepository, CustomerServiceImpl customerService) {
        this.sellerRepository = sellerRepository;
        this.customerService = customerService;
    }



    @Override
    public Seller save(SellerDto sellerDto) {
        Seller seller = new Seller();
        setSeller(seller, sellerDto);
        return sellerRepository.save(seller);
    }


    public void setSeller(Seller seller, SellerDto sellerDto) {
        Customer customer =  customerService.getCustomerById(sellerDto.getCustomer_id());
        if(customer != null) {
            seller.setId(sellerDto.getId());
            seller.setName(sellerDto.getName());
            seller.setFirstDay(sellerDto.getFirstDay());
            seller.setCustomer(customer);
        }

    }



    @Override
    public Seller update(SellerDto sellerDto) {
        Seller seller = new Seller();
        setSeller(seller, sellerDto);
        return sellerRepository.save(seller);
    }



    @Override
    public boolean delete(Long id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (seller.isPresent()) {
            sellerRepository.delete(seller.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Optional<Seller> findById(Long id) {
        return sellerRepository.findById(id);
    }
}
