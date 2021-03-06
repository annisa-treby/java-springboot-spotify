package com.enigma.sepotifay.repository;

import com.enigma.sepotifay.entity.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {
public Page<Album> findAllByAlbumContains(String album, Pageable pageable);
}
