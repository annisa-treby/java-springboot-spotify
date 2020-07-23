package com.enigma.sepotifay.service;

import com.enigma.sepotifay.entity.Artist;
import com.enigma.sepotifay.entity.Song;
import com.enigma.sepotifay.exception.ResourceNotFoundException;
import com.enigma.sepotifay.repository.ArtistRepository;
import com.enigma.sepotifay.specification.ArtistSpecification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ArtistServicesDBImpl implements ArtistServices{

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Artist saveArtist(Artist artist) {
       return artistRepository.save(artist);
    }


    @Override
    public Artist getArtistById(String id) {
        Artist artist = new Artist();
        if(artistRepository.findById(id).isPresent()){
            artist = artistRepository.findById(id).get();
        } else {
            throw new ResourceNotFoundException(id, Artist.class);
        }
        return artist;
    }

    @Override
    public void deleteArtist(String id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Page<Artist> searchArtistBySearchForm(Artist searchForm, Pageable pageable) {
        Page<Artist> artists = artistRepository.findAll(ArtistSpecification.findAll(searchForm), pageable);
        return artists;
    }

    @Override
    public List<Song> getSongByArtist(String id) {
        return artistRepository.findById(id).get().getSongList();
    }

    @Override
    public Artist saveArtistWithImage(MultipartFile multipartFile, String requestBody) throws IOException {
        Artist artist = saveArtist(objectMapper.readValue(requestBody, Artist.class));
        File upload = new File("/home/annisa/Downloads/PhotoDatabase"+ artist.getId());
        multipartFile.transferTo(upload);
        artist.setPhoto(upload.getPath());
        return artistRepository.save(artist);
    }
}
