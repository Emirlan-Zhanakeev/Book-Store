package com.example.bookstore.controller;

import com.example.bookstore.dto.SellerDto;
import com.example.bookstore.model.Seller;
import com.example.bookstore.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping(value = "/saveSeller")
    public ResponseEntity<?> save(@RequestBody SellerDto sellerDto) {
        Seller response = sellerService.save(sellerDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Something wrong", HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/updateSeller")
    public ResponseEntity<?> update(@RequestBody SellerDto sellerDto) {
        Seller response = sellerService.update(sellerDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Something wrong", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllSellers")
    public ResponseEntity<?> getAll() {
        List<Seller> response = sellerService.getAll();
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Something wrong", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/deleteSeller/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean response = sellerService.delete(id);
        return response
                ? new ResponseEntity<>(true     , HttpStatus.OK)
                : new ResponseEntity<>("Something wrong", HttpStatus.NOT_FOUND);
    }
}

