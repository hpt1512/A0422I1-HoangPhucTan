package com.example.m3phuctanthithuchanhlan2.service;

import com.example.m3phuctanthithuchanhlan2.model.PayType;
import com.example.m3phuctanthithuchanhlan2.repository.IBaseRepository;
import com.example.m3phuctanthithuchanhlan2.repository.PayTypeRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class PayTypeServiceImpl implements IBaseService<PayType>{
    IBaseRepository<PayType> payTypeRepository = new PayTypeRepositoryImpl();
    @Override
    public List<PayType> findAll() {
        return payTypeRepository.findAll();
    }

    @Override
    public void insert(PayType payType) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(PayType payType) throws SQLException {
        return false;
    }

    @Override
    public PayType getById(int id) {
        return null;
    }

    @Override
    public List<PayType> findByName(String idFind, String nameFind, String phoneNumberFind) {
        return null;
    }
}
