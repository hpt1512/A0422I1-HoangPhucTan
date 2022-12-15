package com.example.musicapp.model;

import javax.persistence.*;

@Entity(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", columnDefinition = "varchar(45)")
    private String name;
    @Column(name = "singer", columnDefinition = "varchar(45)")
    private String singer;
    @Column(name = "kind_of_music", columnDefinition = "varchar(45)")
    private String kindOfMusic;
    @Column(name = "path_file", columnDefinition = "varchar(100)")
    private String pathFile;

    public Song() {
    }

    public Song(int id, String name, String singer, String kindOfMusic, String pathFile) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        this.pathFile = pathFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
