package com.example.furamamanagement.repository.education_degree;

import com.example.furamamanagement.model.EducationDegree;

import java.util.List;

public interface IEducationDegreeRepository {
    List<EducationDegree> selectAllEducationDegrees();
}
