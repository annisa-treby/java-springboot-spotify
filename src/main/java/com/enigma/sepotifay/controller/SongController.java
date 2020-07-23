package com.enigma.sepotifay.controller;

import com.enigma.sepotifay.entity.Artist;
import com.enigma.sepotifay.entity.Song;
import com.enigma.sepotifay.service.SongServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    SongServices songServices;

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable String id){
        return songServices.getSongById(id);
    }

    @PostMapping
    public void saveSong(@RequestBody Song song){
        songServices.saveSong(song);
    }

    @DeleteMapping
    public void deleteSong(@RequestBody Song song){
        songServices.deleteSong(song.getId());
    }

    @GetMapping
    public Page<Song> searchSong(@RequestBody Song song, @RequestParam Integer page, @RequestParam Integer size){
       Pageable pageable = PageRequest.of(page, size);
       return songServices.searchSong(song, pageable);
    }


  }
