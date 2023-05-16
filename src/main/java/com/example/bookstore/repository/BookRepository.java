package com.example.bookstore.repository;

import com.example.bookstore.dto.BooksPurchaseDto;
import com.example.bookstore.dto.BooksPriceDto;
import com.example.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends  JpaRepository<Book, Long> {
    List<Book> findAllByName(String name);

    @Query(value = "select b.\"name\" , b.price  from books b", nativeQuery = true)
    List<BooksPriceDto> getAllBooksPrice();

    @Query(value = "select b.id as bookId, b.\"name\" as bookName, b.price, c.id, c.\"name\" from books b\n" +
            "left join customer c ON c.id = b.customer_id \n", nativeQuery = true)
    List<BooksPurchaseDto> BooksSold();
}
