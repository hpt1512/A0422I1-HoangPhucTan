package com.example.furamamanagement.service.position;

import com.example.furamamanagement.model.Position;
import com.example.furamamanagement.repository.position.IPositionRepository;
import com.example.furamamanagement.repository.position.PositionRepositoryImpl;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    IPositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> selectAllPositions() {
        return positionRepository.selectAllPositions();
    }
}
