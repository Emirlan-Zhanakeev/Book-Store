package com.example.bookstore.service;

import com.example.bookstore.model.Customer;

import javax.crypto.Cipher;
import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Customer customer);
    boolean deleteCustomer(Long id);
    Customer getCustomerById(Long id);


}
