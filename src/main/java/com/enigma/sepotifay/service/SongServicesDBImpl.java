package com.enigma.sepotifay.service;

import com.enigma.sepotifay.entity.Artist;
import com.enigma.sepotifay.entity.Song;
import com.enigma.sepotifay.exception.ResourceNotFoundException;
import com.enigma.sepotifay.repository.ArtistRepository;
import com.enigma.sepotifay.repository.SongRepository;
import com.enigma.sepotifay.specification.SongSprecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServicesDBImpl implements SongServices{

    @Autowired
    SongRepository songRepository;

    @Autowired
    ArtistServices artistServices;

    @Override
    public void saveSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song getSongById(String id) {
        Song song = new Song();
        if(songRepository.findById(id).isPresent()) {
            songRepository.findById(id).get();
        } else {
            throw new ResourceNotFoundException(id, Song.class);
        }
        return song;
    }
    @Override
    public void deleteSong(String id) {
        songRepository.deleteById(id); }

    @Override
    public Page<Song> searchSong(Song song, Pageable pageable) {
            Page<Song> songs =songRepository.findAll(SongSprecification.findAll(song), pageable);
        return songs;
    }
}
