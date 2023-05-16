package com.example.bookstore.controller;

import com.example.bookstore.model.Customer;
import com.example.bookstore.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/addCustomer")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        Customer response = customerService.saveCustomer(customer);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getAllCustomers")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> response = customerService.getAllCustomers();
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/updateCustomer")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
    Customer response = customerService.updateCustomer(customer);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/deleteCustomer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        boolean response = customerService.deleteCustomer(id);
        return response
                ? new ResponseEntity<>(true, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }


}
