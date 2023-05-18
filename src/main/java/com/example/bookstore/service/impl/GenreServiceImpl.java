package com.example.bookstore.service.impl;

import com.example.bookstore.model.Genre;
import com.example.bookstore.repository.GenreRepository;
import com.example.bookstore.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre update(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Genre> genre = findById(id);
        if (genre.isPresent()) {
            genreRepository.delete(genre.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }
}
