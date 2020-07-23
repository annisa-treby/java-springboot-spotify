package com.enigma.sepotifay.controller;

import com.enigma.sepotifay.entity.Album;
import com.enigma.sepotifay.service.AlbumServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumServices albumServices;

    @GetMapping("/{id}")
    public Album getAlbumById(@PathVariable String id){return albumServices.getAlbumById(id);}

    @PostMapping
    public void saveAlbum(@RequestBody Album album){
        albumServices.saveAlbum(album);
    }

    @DeleteMapping
    public void deleteAlbum(@RequestBody Album album){
        albumServices.deleteAlbum(album.getId());
    }

    @GetMapping
    public Page<Album> getAllAlbum(@RequestBody Album album, @RequestParam Integer page, @RequestParam Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return albumServices.searchAlbum(album, pageable);
    }
}
