package com.enigma.sepotifay.service;

import com.enigma.sepotifay.entity.Artist;
import com.enigma.sepotifay.repository.ArtistRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ArtistServicesDBImplTest {

    @Autowired
    ArtistServices artistServices;

    @MockBean
    ArtistRepository artistRepository;

    @BeforeEach
    public void cleanup(){
        artistRepository.deleteAll();
    }
    @Test
    void saveArtist_shouldCallArtistRepository_save_once_when_called() {
        Artist artist = new Artist();
        artist.setName("5 Seconds Of Summer");
        artist.setBiography("Australia");
        artist.setType("Group BAND");
        artist.setDebutYear(new Date());

        artistServices.saveArtist(artist);
        Mockito.verify(artistRepository, Mockito.times(1)).save(artist);
    }

    @Test
    void saveArtist_should_create_1artist_inDB_when_anArtist_saved() {
        Artist artist = new Artist();
        artist.setName("5 Seconds Of Summer");
        artist.setBiography("Australia");
        artist.setType("Group BAND");
        artist.setDebutYear(new Date());

        artistServices.saveArtist(artist);
        List<Artist> artists = new ArrayList<>();
        artists.add(artist);

        Mockito.when(artistRepository.findAll()).thenReturn(artists);
    }
    @Test
    void saveArtist_should_create_2artist_inDB_when_2Artist_saved() {
        Artist artist = new Artist();
        artist.setName("5 Seconds Of Summer");
        artist.setBiography("Australia");
        artist.setType("Group BAND");
        artist.setDebutYear(new Date());

        Artist artist1 = new Artist();
        artist1.setName("5 Seconds Of Summer");
        artist1.setBiography("Australia");
        artist1.setType("Group BAND");
        artist1.setDebutYear(new Date());

        artistServices.saveArtist(artist);
        artistServices.saveArtist(artist1);

        List<Artist> artists = new ArrayList<>();
        artists.add(artist);
        artists.add(artist1);

        Mockito.when(artistRepository.findAll()).thenReturn(artists);
    }
//    @Test
//    void saveArtist_should_create_correctName_inDB_when_artistSaved() {
//       Artist artist1 = new Artist();
//        artist1.setName("5 Seconds Of Summer");
//        artist1.setBiography("Australia");
//        artist1.setType("Group BAND");
//        artist1.setDebutYear(new Date());
//
//        artist1 = artistServices.saveArtist(artist1);
//
//        Artist actualArtist = artistRepository.findById(artist1.getId()).get();
//
//       Mockito.verify(artist1.equals(actualArtist));
//    }



//    @Test
//    void getArtistById() {
//        Artist artist = new Artist();
//        artist.setName("Shawn Mendes");
//        artist.setBiography("Canada");
//        artist.setType("Solo");
//        artist.setDebutYear(new Date());
//
//        artistRepository.save(artist);
//
//        Artist artist1 = artistServices.getArtistById(artist.getId());
//        assertEquals(artist, artist1);
//    }

    @Test
    void deleteArtist() {
        Artist artist = new Artist();
        artist.setName("Camila Cabelo");
        artist.setBiography("Canada");
        artist.setType("Solo");
        artist.setDebutYear(new Date());

        artistRepository.save(artist);
        artistServices.deleteArtist(artist.getId());

        assertEquals(0, artistRepository.findAll().size());
    }

//    @Test
//    void searchArtistBySearchForm() {
//
//        Artist artist1 = new Artist();
//        artist1.setName("Shawn Mendes");
//        artist1.setBiography("Canada");
//        artist1.setType("Solo");
//        artist1.setDebutYear(new Date());
//
//        Artist artist2 = new Artist();
//        artist2.setName("Camila Cabello");
//        artist2.setBiography("Canada");
//        artist2.setType("Solo");
//        artist2.setDebutYear(new Date());
//
//            artistRepository.save(artist1);
//        artistRepository.save(artist2);
//
//        Page<Artist> artists = artistServices.searchArtistBySearchForm(artist1,PageRequest.of(0, 1));
//
//        assertEquals(1, artists.getTotalElements());
//    }

    @Test
    void getSongByArtist() {
    }
}