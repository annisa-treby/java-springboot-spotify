package com.enigma.sepotifay.service;

import com.enigma.sepotifay.entity.Album;
import com.enigma.sepotifay.exception.ResourceNotFoundException;
import com.enigma.sepotifay.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlbumServicesDBImpl implements AlbumServices{

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public void saveAlbum(Album album) {
        albumRepository.save(album);
    }

    @Override
    public Page<Album> searchAlbum(Album album, Pageable pageable) {
        Page<Album> albums = albumRepository.findAllByAlbumContains(album.getAlbum(), pageable);
        return albums;
    }

    @Override
    public Album getAlbumById(String id) {
        Album album = new Album();
        if(albumRepository.findById(id).isPresent()){
            album = albumRepository.findById(id).get();
        } else {
            throw new ResourceNotFoundException(id, Album.class);
        }
        return album;
    }

    @Override
    public void deleteAlbum(String id) {
        Album album = getAlbumById(id);
        albumRepository.delete(album);
    }
}
