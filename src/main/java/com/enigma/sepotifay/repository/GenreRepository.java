package com.enigma.sepotifay.repository;

import com.enigma.sepotifay.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, String> {
}
