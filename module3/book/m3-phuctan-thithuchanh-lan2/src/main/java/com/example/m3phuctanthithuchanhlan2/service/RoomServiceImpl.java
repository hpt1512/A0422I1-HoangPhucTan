package com.example.m3phuctanthithuchanhlan2.service;

import com.example.m3phuctanthithuchanhlan2.model.Room;
import com.example.m3phuctanthithuchanhlan2.repository.IBaseRepository;
import com.example.m3phuctanthithuchanhlan2.repository.RoomRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class RoomServiceImpl implements IBaseService<Room>{
    IBaseRepository<Room> roomRepository = new RoomRepositoryImpl();
    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public void insert(Room room) throws SQLException {
        roomRepository.insert(room);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return roomRepository.delete(id);
    }

    @Override
    public boolean update(Room room) throws SQLException {
        return roomRepository.update(room);
    }

    @Override
    public Room getById(int id) {
        return roomRepository.getById(id);
    }

    @Override
    public List<Room> findByName(String idFind, String nameFind, String phoneNumberFind) {
        return roomRepository.findByName(idFind, nameFind, phoneNumberFind);
    }
}
