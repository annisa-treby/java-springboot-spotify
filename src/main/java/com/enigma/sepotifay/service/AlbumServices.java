package com.enigma.sepotifay.service;

import com.enigma.sepotifay.entity.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlbumServices {
    public void saveAlbum(Album album);
    public Page<Album> searchAlbum(Album album, Pageable pageable);
    public Album getAlbumById(String id);
    public void deleteAlbum(String id);
}
