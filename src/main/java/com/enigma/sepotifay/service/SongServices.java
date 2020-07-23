package com.enigma.sepotifay.service;

import com.enigma.sepotifay.entity.Artist;
import com.enigma.sepotifay.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SongServices {
    public void saveSong(Song song);
    public Song getSongById(String id);
    public void deleteSong(String id);
    public Page<Song> searchSong(Song song, Pageable pageable);
}
