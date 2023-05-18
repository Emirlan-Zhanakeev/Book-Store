package com.example.bookstore.controller;

import com.example.bookstore.model.Sale;
import com.example.bookstore.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping(value = "getAllSale")
    public ResponseEntity<?> getAllSale() {
        return new ResponseEntity<>(saleService.getAllSale(), HttpStatus.OK);
    }

    @PostMapping(value = "/saveSale")
    public ResponseEntity<?> saveSale(@RequestBody Sale sale) {
        Sale response = (saleService.saveSale(sale));
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Something wrong", HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/updateSale")
    public ResponseEntity<?> updateSale(@RequestBody Sale sale) {
        Sale response = (saleService.updateSale(sale));
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Something wrong", HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/deleteSale/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable Long id) {
        boolean response = (saleService.deleteSale(id));
        return response
                ? new ResponseEntity<>(true, HttpStatus.OK)
                : new ResponseEntity<>("Something wrong", HttpStatus.NOT_FOUND);
    }
}
