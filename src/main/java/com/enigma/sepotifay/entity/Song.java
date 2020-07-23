package com.enigma.sepotifay.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mst_song")
public class Song {
    @Id
    @GeneratedValue(generator = "song_uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "song_uuid", strategy = "uuid")
    private String id;

    private String title;

    @ManyToMany
    @JoinColumn(name = "genre_id")
    @JsonIgnoreProperties("songList")
    private List<Genre> genreList;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")
    @JsonIgnoreProperties("song")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnoreProperties("songList")
    private Artist artist;

    @Transient
    @JsonBackReference
    private String artis;

    public Song() {
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date release) {
        this.releaseDate = release;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
