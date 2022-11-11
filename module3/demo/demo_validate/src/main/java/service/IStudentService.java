package service;

import model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    List<Student> findAll();
    List<Student> search(String searchName, String searchAccount, String classId);
    Map<String, String> add(Student student);
    boolean delete(int id);
}
