package com.enigma.sepotifay.service;

import com.enigma.sepotifay.entity.Genre;
import com.enigma.sepotifay.exception.ResourceNotFoundException;
import com.enigma.sepotifay.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServicesDBImpl implements GenreServices{

    @Autowired
    GenreRepository genreRepository;

    @Override
    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public Page<Genre> getAllGenre() {
        return null;
    }

    @Override
    public Genre getGenreById(String id) {
        Genre genre =  new Genre();
        if(genreRepository.findById(id).isPresent()) {
            genre = genreRepository.findById(id).get();
        } else {
            throw new ResourceNotFoundException(id, Genre.class);
        }
        return genre;
    }

    @Override
    public void deleteGenre(Genre genre) {
        genreRepository.delete(genre);
    }
}
