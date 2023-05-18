package com.example.bookstore.service;


import com.example.bookstore.model.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GenreService {
    Genre save(Genre genre);
    Genre update(Genre genre);
    boolean delete(Long id);
    List<Genre> getAll();
    Optional<Genre> findById(Long id);
}
