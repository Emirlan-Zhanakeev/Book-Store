package com.example.bookstore.service;


import com.example.bookstore.dto.BooksPurchaseDto;
import com.example.bookstore.dto.BooksCustomerIdGenreIdDto;
import com.example.bookstore.dto.BooksPriceDto;
import com.example.bookstore.model.Book;

import java.util.List;

public interface BookService {
    Book save(BooksCustomerIdGenreIdDto booksAndCustomerIdDto);
    void convertEntityToDto(Book book, BooksCustomerIdGenreIdDto booksAndCustomerIdDto);
    List<Book> getAll();
    Book getById(Long id);
    boolean delete(Long id);
    Book update(Book book);
    List<Book> findAllByName(String name);
    List<BooksPriceDto> getAllBooksPrice();
    List<BooksPurchaseDto> booksSold();
}
