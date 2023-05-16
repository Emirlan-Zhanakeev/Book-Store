package com.example.bookstore.service.impl;


import com.example.bookstore.dto.BooksAndCustomerIdDto;
import com.example.bookstore.dto.BooksPriceDto;
import com.example.bookstore.dto.BooksPurchaseDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Customer;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final CustomerServiceImpl customerService;

    public BookServiceImpl(BookRepository repository, CustomerServiceImpl customerService) {
        this.repository = repository;
        this.customerService = customerService;

    }

    public List<Book> findAllByName(String name) {
        List<Book> books = repository.findAllByName(name);
        for (Book book : books) {
            System.out.println(book);
        }
        return books;
    }

    @Override
    public List<BooksPriceDto> getAllBooksPrice() {
        return repository.getAllBooksPrice();
    }

    @Override
    public List<BooksPurchaseDto> booksSold() {
        return repository.BooksSold();
    }


    @Override
    public Book save(BooksAndCustomerIdDto booksAndCustomerIdDto) {
        Book book = new Book();
        convertEntityToDto(book, booksAndCustomerIdDto);
        return repository.save(book);
    }

    @Override
    public void convertEntityToDto(Book book, BooksAndCustomerIdDto booksAndCustomerIdDto) {
        Customer customer = customerService.getCustomerById(booksAndCustomerIdDto.getCustomer_id());
        if (customer != null) {
        book.setId(booksAndCustomerIdDto.getId());
        book.setName(booksAndCustomerIdDto.getName());
        book.setAuthor(booksAndCustomerIdDto.getAuthor());
        book.setPrice(booksAndCustomerIdDto.getPrice());
        book.setCustomer(customer);
        }
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
        if (book != null) {
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
