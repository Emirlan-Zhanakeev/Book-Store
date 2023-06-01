package com.example.bookstore.controller;

import com.example.bookstore.model.Sale;
import com.example.bookstore.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }
    @PreAuthorize("hasAnyAuthority('davelopers:read')")
    @GetMapping(value = "getAllSale")
    public ResponseEntity<?> getAllSale() {
        return new ResponseEntity<>(saleService.getAllSale(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('developers:write')")
    @PostMapping(value = "/saveSale")
    public ResponseEntity<?> saveSale(@RequestBody Sale sale) {
        Sale response = (saleService.saveSale(sale));
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Something wrong", HttpStatus.NOT_FOUND);
    }
    @PreAuthorize("hasAnyAuthority('developers:write')")
    @PutMapping(value = "/updateSale")
    public ResponseEntity<?> updateSale(@RequestBody Sale sale) {
        Sale response = (saleService.updateSale(sale));
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Something wrong", HttpStatus.NOT_FOUND);
      }
    @PreAuthorize("hasAnyAuthority('developers:write')")
    @DeleteMapping(value = "/deleteSale/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable Long id) {
        boolean response = (saleService.deleteSale(id));
        return response
                ? new ResponseEntity<>(true, HttpStatus.OK)
                : new ResponseEntity<>("Something wrong", HttpStatus.NOT_FOUND);
    }
}
