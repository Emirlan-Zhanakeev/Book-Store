package com.example.bookstore.service.impl;


import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAllByName(String name) {
        List<Book> books = repository.findAllByName(name);
        for (Book book : books) {
            System.out.println(book);
        }
            return books;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long bookId) {
        Book book = getById(bookId);
        if (book != null){
            repository.delete(book);
            return true;
        }
        return false;
    }

    @Override
    public Book update(Book book) {
        return repository.save(book);
    }

}
