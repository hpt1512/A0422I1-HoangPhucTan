package com.example.furamamanagement.controller;

import com.example.furamamanagement.model.Customer;
import com.example.furamamanagement.model.CustomerType;
import com.example.furamamanagement.service.customer.CustomerServiceImpl;
import com.example.furamamanagement.service.customer_type.CustomerTypeServiceImpl;
import com.example.furamamanagement.service.customer.ICustomerService;
import com.example.furamamanagement.service.customer_type.ICustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService;
    private ICustomerTypeService customerTypeService;

    public void init() {
        customerService = new CustomerServiceImpl();
        customerTypeService = new CustomerTypeServiceImpl();
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
                    deleteCustomer(request, response);
                    break;
                case "view":
                    viewCustomer(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.getCustomerById(id);
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerTypes();
        request.setAttribute("customer", customer);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);

        List<Customer> customerList = customerService.selectAllCustomers();
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerTypes();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/list.jsp");
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
        Customer customer = customerService.getCustomerById(id);
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerTypes();
        request.setAttribute("customer", customer);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerTypes();
        request.setAttribute("customerTypeList", customerTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.selectAllCustomers();
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerTypes();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/list.jsp");
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
                    insertCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
                case "find":
                    findCustomer(request, response);
                    break;
            }
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
    }

    private void findCustomer(HttpServletRequest request, HttpServletResponse response) {
        String input_find = request.getParameter("input_find");
        List<Customer> customerList = this.customerService.findByName(input_find);
        List<CustomerType> customerTypeList = this.customerTypeService.selectAllCustomerTypes();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("views/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        String name = request.getParameter("name");
        String strBirthday = request.getParameter("birthday");
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(strBirthday);
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String cmnd = request.getParameter("cmnd");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, customerType, name, birthday, gender, cmnd, phoneNumber, email, address);
        customerService.updateCustomer(customer);
        request.setAttribute("message", "Update customer successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException {
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        String name = request.getParameter("name");
        String strBirthday = request.getParameter("birthday");
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(strBirthday);
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String cmnd = request.getParameter("cmnd");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer newCustomer = new Customer(customerType, name, birthday, gender, cmnd, phoneNumber, email, address);
        customerService.insertCustomer(newCustomer);
        request.setAttribute("message", "Create new customer successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
