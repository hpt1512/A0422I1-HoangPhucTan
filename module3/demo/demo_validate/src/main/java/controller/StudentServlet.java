package controller;

import model.ClassCG;
import model.Student;
import service.ClassService;
import service.IClassService;
import service.IStudentService;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "controller.StudentServlet", urlPatterns = {"/student", "/sinh-vien"})
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();
    private IClassService classService = new ClassService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                save(request, response);
                break;
            case "delete":
                break;
            default:
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        int point = Integer.parseInt(request.getParameter("point"));
        int classId = Integer.parseInt(request.getParameter("classId"));
//        String account = request.getParameter("account");
        Student student = new Student(name, gender, birthday, point, email, classId, email);
        Map<String, String> errorMap = studentService.add(student);
        String mess = "them moi thanh cong";
        if (!errorMap.isEmpty()) {
            request.setAttribute("email",email);
            request.setAttribute("point",point);
            request.setAttribute("errorMap", errorMap);
            mess = "Them moi không thanh cong";
        }
        request.setAttribute("mess", mess);
        try {
            List<ClassCG> classCGList = classService.findAll();
            request.setAttribute("classList", classCGList);
            request.getRequestDispatcher("view/student/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormCreate(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showListStudent(request, response);

        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        String searchAccount = request.getParameter("searchAccount");
        String searchClassId = request.getParameter("classId");

        List<Student> studentList = studentService.search(searchName,searchAccount,searchClassId);
        request.setAttribute("studentList",studentList);

        List<ClassCG> classCGList = classService.findAll();
        request.setAttribute("classList", classCGList);
        try {
            request.getRequestDispatcher("view/student/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int deleteId = Integer.parseInt(request.getParameter("deleteId"));
        studentService.delete(deleteId);
        request.setAttribute("mess", "Xoá thành công");
        showListStudent(request, response);
    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = studentService.findAll();
        request.setAttribute("studentList", studentList);
        List<ClassCG> classCGList = classService.findAll();
        request.setAttribute("classList", classCGList);
        try {
            request.getRequestDispatcher("view/student/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<ClassCG> classCGList = classService.findAll();
        request.setAttribute("classList", classCGList);
        try {
            request.getRequestDispatcher("view/student/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
