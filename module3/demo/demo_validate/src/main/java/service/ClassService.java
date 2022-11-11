package service;

import model.ClassCG;
import repository.ClassRepository;
import repository.IClassRepository;

import java.util.List;

public class ClassService implements IClassService {
    private IClassRepository classRepository = new ClassRepository();
    @Override
    public List<ClassCG> findAll() {
        return classRepository.findAll();
    }
}
