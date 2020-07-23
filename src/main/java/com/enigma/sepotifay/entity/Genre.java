package com.enigma.sepotifay.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mst_genre")
public class Genre {

    @Id
    @GeneratedValue(generator = "genre_uuid")
    @GenericGenerator(name = "genre_uuid", strategy = "uuid")
    private String id;
    private String genre;

    @ManyToMany( mappedBy = "genreList")
    @JsonIgnoreProperties("genreList")
    private List<Song> songList;

    public Genre() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
