package com.enigma.sepotifay.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mst_album")
public class Album {

    @Id
    @GeneratedValue(generator = "album_uuid")
    @GenericGenerator(name = "album_uuid", strategy = "uuid")
    private String id;
    private String album;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "album")
    @JsonIgnoreProperties("album")
    private List<Song> song = new ArrayList<>();

    public Album() {
    }

    public Album(String id, String album) {
        this.id = id;
        this.album = album;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }
}
