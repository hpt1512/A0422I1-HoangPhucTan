package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    List<Student> search(String searchName, String searchAccount, String classId);
    boolean add(Student student);
    boolean delete(int id);
}
