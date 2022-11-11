package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepository;
import validate.Validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService  implements  IStudentService{
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> search(String searchName, String searchAccount, String classId) {
        return studentRepository.search(searchName,searchAccount,classId);
    }

    @Override
    public Map<String, String> add(Student student) {
        // kiểm tra dữ liệu
        Map<String, String> errorMap = new HashMap<>();
        if ("".equals(student.getEmail())){
            errorMap.put("email","Email không được để trống");
        }else if(!Validation.checkEmail(student.getEmail())){
            errorMap.put("email","Email không đúng định dạng");
        }
        if (student.getPoint()<0){
            errorMap.put("point","Điểm phải lớn hơn 0");
        }else if (student.getPoint()>10){
            errorMap.put("point","Điểm phải nhỏ hơn 10");
        }
        // nêu không có lỗi thì cho lưu vào db
        if (errorMap.isEmpty()){
            studentRepository.add(student);
        }
        return errorMap;
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }
}
