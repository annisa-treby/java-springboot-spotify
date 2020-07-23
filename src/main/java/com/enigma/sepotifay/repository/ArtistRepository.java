package com.enigma.sepotifay.repository;

import com.enigma.sepotifay.entity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String>, JpaSpecificationExecutor<Artist> {
}
