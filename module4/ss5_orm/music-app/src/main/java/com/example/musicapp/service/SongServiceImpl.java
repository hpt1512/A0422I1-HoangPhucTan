package com.example.musicapp.service;

import com.example.musicapp.model.Song;
import com.example.musicapp.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    ISongRepository songRepository;
    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void update(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(Song song) {
        songRepository.delete(song);
    }

    @Override
    public Song getBlogById(int id) {
        return songRepository.findById(id).orElse(null);
    }
}
