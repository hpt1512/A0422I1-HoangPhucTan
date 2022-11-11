package com.example.furamamanagement.controller;

import com.example.furamamanagement.model.*;
import com.example.furamamanagement.service.division.DivisionServiceImpl;
import com.example.furamamanagement.service.division.IDivisionService;
import com.example.furamamanagement.service.education_degree.EducationDegreeServiceImpl;
import com.example.furamamanagement.service.education_degree.IEducationDegreeService;
import com.example.furamamanagement.service.employee.EmployeeServiceImpl;
import com.example.furamamanagement.service.employee.IEmployeeService;
import com.example.furamamanagement.service.position.IPositionService;
import com.example.furamamanagement.service.position.PositionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService;
    private IPositionService positionService;
    private IEducationDegreeService educationDegreeService;
    private IDivisionService divisionService;

    public void init() {
        employeeService = new EmployeeServiceImpl();
        positionService = new PositionServiceImpl();
        educationDegreeService = new EducationDegreeServiceImpl();
        divisionService = new DivisionServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                case "view":
                    viewEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = positionService.selectAllPositions();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegrees();
        List<Division> divisionList = divisionService.selectAllDivisions();
        List<Employee> employeeList = employeeService.selectAllEmployees();

        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void viewEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployeeById(id);
        List<Position> positionList = positionService.selectAllPositions();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegrees();
        List<Division> divisionList = divisionService.selectAllDivisions();

        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("employee", employee);


        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);

        List<Employee> employeeList = employeeService.selectAllEmployees();
        List<Position> positionList = positionService.selectAllPositions();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegrees();
        List<Division> divisionList = divisionService.selectAllDivisions();

        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployeeById(id);
        List<Position> positionList = positionService.selectAllPositions();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegrees();
        List<Division> divisionList = divisionService.selectAllDivisions();

        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = positionService.selectAllPositions();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegrees();
        List<Division> divisionList = divisionService.selectAllDivisions();

        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
                case "find":
                    findEmployee(request, response);
                    break;
            }
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
    }

    private void findEmployee(HttpServletRequest request, HttpServletResponse response) {
        String input_find = request.getParameter("input_find");
        List<Employee> employeeList = this.employeeService.findByName(input_find);
        List<Position> positionList = positionService.selectAllPositions();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegrees();
        List<Division> divisionList = divisionService.selectAllDivisions();

        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("employeeList", employeeList);

        try {
            request.getRequestDispatcher("views/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String strBirthday = request.getParameter("birthday");
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(strBirthday);
        String cmnd = request.getParameter("cmnd");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idPosition = Integer.parseInt(request.getParameter("position"));
        int idEducationDegree = Integer.parseInt(request.getParameter("education_degree"));
        int idDivision = Integer.parseInt(request.getParameter("division"));

        Employee employee = new Employee(id, name, birthday, cmnd, salary, phoneNumber, email, address, idPosition, idEducationDegree, idDivision);
        employeeService.updateEmployee(employee);
        request.setAttribute("message", "Update employee successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException{
        String name = request.getParameter("name");
        String strBirthday = request.getParameter("birthday");
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(strBirthday);
        String cmnd = request.getParameter("cmnd");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idPosition = Integer.parseInt(request.getParameter("position"));
        int idEducationDegree = Integer.parseInt(request.getParameter("education_degree"));
        int idDivision = Integer.parseInt(request.getParameter("division"));

        Employee newEmployee = new Employee(name, birthday, cmnd, salary, phoneNumber, email, address, idPosition, idEducationDegree, idDivision);
        employeeService.insertEmployee(newEmployee);
        request.setAttribute("message", "Create new employee successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
