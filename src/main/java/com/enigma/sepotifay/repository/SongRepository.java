package com.enigma.sepotifay.repository;

import com.enigma.sepotifay.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, String>, JpaSpecificationExecutor<Song> {
}
