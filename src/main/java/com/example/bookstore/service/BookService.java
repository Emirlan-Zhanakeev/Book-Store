package com.example.bookstore.service;


import com.example.bookstore.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book> getAll();
    Book getById(Long id);
    boolean delete(Long id);
    Book update(Book book);
    List<Book> findAllByName(String name);
}
