package com.example.bookstore.service.impl;

import com.example.bookstore.dto.BooksCustomerIdGenreIdDto;
import com.example.bookstore.dto.BooksPriceDto;
import com.example.bookstore.dto.BooksPurchaseDto;
import com.example.bookstore.model.*;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final CustomerServiceImpl customerService;
    private final GenreServiceImpl genreService;
    private final SellerServiceImpl sellerService;
    private final SaleServiceImpl saleService;

    public BookServiceImpl(BookRepository repository, CustomerServiceImpl customerService, GenreServiceImpl genreService, SellerServiceImpl sellerService, SaleServiceImpl saleService) {
        this.repository = repository;
        this.customerService = customerService;
        this.genreService = genreService;
        this.sellerService = sellerService;
        this.saleService = saleService;
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
    public Book save(BooksCustomerIdGenreIdDto booksAndCustomerIdDto) {
        Book book = new Book();
        convertEntityToDto(book, booksAndCustomerIdDto);
        return repository.save(book);
    }

    @Override
    public void convertEntityToDto(Book book, BooksCustomerIdGenreIdDto booksAndCustomerIdDto) {
        Customer customer = customerService.getCustomerById(booksAndCustomerIdDto.getCustomer_id());
        Optional<Genre> genre = genreService.findById(booksAndCustomerIdDto.getGenre_id());
        Optional<Sale> sale = saleService.getSaleById(booksAndCustomerIdDto.getSale_id());
        Optional<Seller> seller = sellerService.findById(booksAndCustomerIdDto.getSeller_id());
        if (customer != null) {
        book.setId(booksAndCustomerIdDto.getId());
        book.setName(booksAndCustomerIdDto.getName());
        book.setAuthor(booksAndCustomerIdDto.getAuthor());
        book.setPrice(booksAndCustomerIdDto.getPrice());
        book.setCustomer(customer);
        book.setGenre(genre.get());
        book.setSale(sale.get());
        book.setSeller(seller.get());
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
