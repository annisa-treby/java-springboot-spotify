package com.enigma.sepotifay.service;

import com.enigma.sepotifay.entity.Genre;
import com.enigma.sepotifay.entity.Song;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GenreServices {
    public void saveGenre(Genre genre);
    public Page<Genre> getAllGenre();
    public Genre getGenreById(String id);
    public void deleteGenre(Genre genre);
}
