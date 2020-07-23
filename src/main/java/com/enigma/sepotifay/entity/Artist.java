package com.enigma.sepotifay.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mst_artist")
public class Artist {

    @Id
    @GeneratedValue(generator = "artist_uuid")
    @GenericGenerator(name = "artist_uuid", strategy = "uuid")
    private String id;
    private String name;
    private String biography;
    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date debutYear;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Transient
    @JsonBackReference
    private String title;

    @Transient
    private Integer countSong;

    private String photo;

    @OneToMany(mappedBy = "artist")
    @JsonIgnoreProperties("artist")
    @JsonIgnore
    private List<Song> songList = new ArrayList<>();

    public Artist() {
    }

    public Integer getCountSong() {
        return songList.size();
    }

    public void setCountSong(Integer countSong) {
        this.countSong = countSong;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String originPlace) {
        this.biography = originPlace;
    }

    public Date getDebutYear() {
        return debutYear;
    }

    public void setDebutYear(Date debut) {
        this.debutYear = debut;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) &&
                Objects.equals(name, artist.name) &&
                Objects.equals(biography, artist.biography) &&
                Objects.equals(type, artist.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, biography, type);
    }
}
