package com.example.bookstore.controller;

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
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.OK);
    }

    @GetMapping(Endpoint.GET)
    public ResponseEntity<List<Book>> getAll() {
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping(Endpoint.GET + "allByName")
    public ResponseEntity<List<Book>> getAllByName(@RequestParam String name) {
        return new ResponseEntity<>(bookService.findAllByName(name), HttpStatus.OK);
    }

    @GetMapping(Endpoint.GETBYID)
    public ResponseEntity<Book> getById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(bookService.getById(id), HttpStatus.OK);
    }

    @PutMapping(Endpoint.UPDATE)
    public ResponseEntity<Book> update(@RequestBody Book book) {

        return new ResponseEntity<>(bookService.update(book), HttpStatus.OK);
    }

    @DeleteMapping(Endpoint.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean response = bookService.delete(id);
        return response
                ? new ResponseEntity<>("Book was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
