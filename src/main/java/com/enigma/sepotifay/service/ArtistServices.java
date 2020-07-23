package com.enigma.sepotifay.service;

import com.enigma.sepotifay.entity.Artist;
import com.enigma.sepotifay.entity.Song;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ArtistServices {
    public Artist saveArtist(Artist artist);
    public Artist getArtistById(String id);
    public void deleteArtist(String id);
    public Page<Artist> searchArtistBySearchForm(Artist searchform, Pageable pageable);
    public List<Song> getSongByArtist(String id);
    public Artist saveArtistWithImage(MultipartFile multipartFile, String requestBody) throws IOException;

}
