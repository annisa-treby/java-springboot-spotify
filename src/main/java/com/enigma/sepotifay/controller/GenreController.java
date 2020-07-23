package com.enigma.sepotifay.controller;

import com.enigma.sepotifay.entity.Genre;
import com.enigma.sepotifay.service.GenreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreServices genreServices;

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable String id){ return genreServices.getGenreById(id);}

    @GetMapping
    public Page<Genre> getAllGenre(@RequestBody Genre searchForm, @RequestParam Integer page, @RequestParam Integer size){
        Pageable pageable = PageRequest.of(page, size);
       return null;
    }

    @PostMapping
    public void saveGenre(@RequestBody Genre genre){
        genreServices.saveGenre(genre);
    }

    @DeleteMapping
    public void deleteGenre(@RequestBody Genre genre){
        genreServices.deleteGenre(genre);
    }
}
