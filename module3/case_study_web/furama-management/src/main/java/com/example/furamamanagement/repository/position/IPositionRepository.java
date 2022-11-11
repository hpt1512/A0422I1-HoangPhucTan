package com.example.furamamanagement.repository.position;

import com.example.furamamanagement.model.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> selectAllPositions();
}
