package com.example.musicapp.service;

import com.example.musicapp.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAll();
    void save(Song song);
    void update(Song song);
    void delete(Song song);
    Song getBlogById(int id);
}
