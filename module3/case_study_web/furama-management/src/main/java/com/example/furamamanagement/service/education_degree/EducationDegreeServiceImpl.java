package com.example.furamamanagement.service.education_degree;

import com.example.furamamanagement.model.EducationDegree;
import com.example.furamamanagement.repository.education_degree.EducationDegreeRepositoryImpl;
import com.example.furamamanagement.repository.education_degree.IEducationDegreeRepository;

import java.util.List;

public class EducationDegreeServiceImpl implements IEducationDegreeService {
    IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();
    @Override
    public List<EducationDegree> selectAllEducationDegrees() {
        return educationDegreeRepository.selectAllEducationDegrees();
    }
}
