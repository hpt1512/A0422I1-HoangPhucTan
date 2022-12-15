package codegym.vn.repository;
import codegym.vn.bean.Student;
import java.util.List;

public interface StudentRepository {
    void createOrUpdate(Student s);
    void create(Student s);
    void update(Student s);
    Student findById(String id);
    List<Student> findAll();
    List<Student> findByName(String name);
    void deleteById(String id);
}
