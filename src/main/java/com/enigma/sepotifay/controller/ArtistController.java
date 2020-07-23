package com.enigma.sepotifay.controller;

import com.enigma.sepotifay.entity.Artist;
import com.enigma.sepotifay.entity.Counter;
import com.enigma.sepotifay.entity.Song;
import com.enigma.sepotifay.service.ArtistServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistServices artistServices;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/add")
    public Counter getCounter(){
        Counter counter = new Counter();
        counter.increment();
        return counter;
    }

    @GetMapping("/{id}")
    public Artist getArtistByID(@PathVariable String id){
        return artistServices.getArtistById(id);
    }

    @PostMapping
    public Artist saveArtist(@RequestBody Artist artist){
        return artistServices.saveArtist(artist);
    }

    @GetMapping
    public Page<Artist> searchArtist(@RequestBody Artist artist, @RequestParam Integer page, @RequestParam Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return artistServices.searchArtistBySearchForm(artist, pageable);
    }

    @GetMapping("/{id}/song")
    public List<Song> getSongByArtist(@PathVariable String id){

        return artistServices.getSongByArtist(id);
    }

    @PostMapping("/image")
    public Artist saveArtist(@RequestPart MultipartFile multipartFile, @RequestPart String artistFormData) throws IOException {

        return artistServices.saveArtistWithImage(multipartFile, artistFormData);
    }

}
