package com.example.bookstore.controller;


import com.example.bookstore.model.Genre;
import com.example.bookstore.service.GenreService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping(value = "/getAllGenres")
    public ResponseEntity<?> getAllGenres() {
        List<Genre> response = genreService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/saveGenre")
    public ResponseEntity<?> saveGenre(@RequestBody Genre genre) {
        Genre response = (genreService.save(genre));
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Something wrong", HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/updateGenre")
    public ResponseEntity<?> updateGenre(@RequestBody Genre genre) {
        Genre response = genreService.update(genre);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/deleteGenre/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable Long id) {
        boolean response = genreService.delete(id);
        return response
                ? new ResponseEntity<>(true, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);

    }

}
