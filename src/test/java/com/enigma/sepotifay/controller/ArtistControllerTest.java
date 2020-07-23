package com.enigma.sepotifay.controller;

import com.enigma.sepotifay.entity.Artist;
import com.enigma.sepotifay.repository.ArtistRepository;
import com.enigma.sepotifay.service.ArtistServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ArtistControllerTest {


    @MockBean
    ArtistServices artistServices;

    @MockBean
    ArtistRepository artistRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getArtistByID() {
    }

    @Test
    void saveArtist_should_return_with_ID_notnull_when_anArtist_saved() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Artist artist = new Artist();
        artist.setName("5 Seconds Of Summer");
        artist.setBiography("Australia");
        artist.setType("Group BAND");
        artist.setDebutYear(new Date());

        Artist mockArtist = new Artist();
        mockArtist.setId("asal");

        //bisikin postman tiruan
        Mockito.when(artistServices.saveArtist(artist)).thenReturn(mockArtist);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/artist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(artist));

        String response =mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

        assertTrue(objectMapper.readValue(response, Artist.class).getId()!=null);
    }
    @Test
    void saveArtist_should_return_Ok200() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Artist artist = new Artist();
        artist.setName("5 Seconds Of Summer");
        artist.setBiography("Australia");
        artist.setType("Group BAND");
        artist.setDebutYear(new Date());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/artist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(artist));
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void saveArtist_should_call_ArtistService_saveArtist_Once() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Artist artist = new Artist();
        artist.setName("5 Seconds Of Summer");
        artist.setBiography("Australia");
        artist.setType("Group BAND");
        artist.setDebutYear(new Date());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/artist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(artist));

        mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

        Mockito.verify(artistServices, Mockito.times(1)).saveArtist(artist);

    }

    @Test
    void artist() {
    }

    @Test
    void getSongByArtist() {
    }
}