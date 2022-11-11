package controller;

import model.Student;
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

@WebServlet(name = "controller.StudentServlet", urlPatterns = {"/student", "/sinh-vien"})
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();

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
        boolean check = studentService.add(student);
        String mess = "them moi khong thanh cong";
        if (check) {
            mess = "Them moi thanh cong";
        }
        request.setAttribute("mess", mess);
        try {
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
            default:
                showListStudent(request, response);

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
        try {
            request.getRequestDispatcher("view/student/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/student/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
