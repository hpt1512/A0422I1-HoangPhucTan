package com.example.display_list_cusomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerListServlet", value = "/customer")
public class CustomerListServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Phuc Tan 1", "15/12/2000", "60 Le Thi Tinh", "image1.jpg"));
        customerList.add(new Customer("Phuc Tan 2", "15/12/2000", "60 Le Thi Tinh", "image1.jpg"));
        customerList.add(new Customer("Phuc Tan 3", "15/12/2000", "60 Le Thi Tinh", "image1.jpg"));
        customerList.add(new Customer("Phuc Tan 4", "15/12/2000", "60 Le Thi Tinh", "image1.jpg"));
        customerList.add(new Customer("Phuc Tan 5", "15/12/2000", "60 Le Thi Tinh", "image1.jpg"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("views/list_customer.jsp").forward(request,response);;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("DOPOST CUSTOMER");
    }
}
