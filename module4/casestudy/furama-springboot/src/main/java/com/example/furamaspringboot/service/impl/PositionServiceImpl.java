package com.example.furamaspringboot.service.impl;

import com.example.furamaspringboot.model.Position;
import com.example.furamaspringboot.repository.IPositionRepository;
import com.example.furamaspringboot.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IBaseService<Position> {
   @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void insert(Position position) {

    }

    @Override
    public void update(Position position) {

    }

    @Override
    public void delete(Position position) {

    }

    @Override
    public Position findById(Integer id) {
        return null;
    }
}
