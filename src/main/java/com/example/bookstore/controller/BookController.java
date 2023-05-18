package com.example.bookstore.controller;

import com.example.bookstore.dto.BooksCustomerIdGenreIdDto;
import com.example.bookstore.dto.BooksPriceDto;
import com.example.bookstore.dto.BooksPurchaseDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(Endpoint.SAVE)
    public ResponseEntity<?> save(@RequestBody BooksCustomerIdGenreIdDto booksAndCustomerIdDto) {
        Book response = bookService.save(booksAndCustomerIdDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }


    @GetMapping(Endpoint.GET)
    public ResponseEntity<List<Book>> getAll() {
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping(Endpoint.GET + "allByName")
    public ResponseEntity<?> getAllByName(@RequestParam String name) {
        List<Book> response = bookService.findAllByName(name);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(Endpoint.GETBYID)
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        Book response = bookService.getById(id);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PutMapping(Endpoint.UPDATE)
    public ResponseEntity<?> update(@RequestBody BooksCustomerIdGenreIdDto booksAndCustomerIdDto) {
        Book response = bookService.save(booksAndCustomerIdDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(Endpoint.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean response = bookService.delete(id);
        return response
                ? new ResponseEntity<>("Book was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/booksPrice")
    public ResponseEntity<?> getAllBooksPrice() {
        List<BooksPriceDto> response = bookService.getAllBooksPrice();
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/booksSold")
    public ResponseEntity<?> booksSold() {
        List<BooksPurchaseDto> response = bookService.booksSold();
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
