package com.example.simple_caculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "CaculatorServlet", value = "/caculator")
@WebServlet(name = "CaculatorServlet", urlPatterns = {"/caculator", "/result"})
public class CaculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/caculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        double first_operand = Double.parseDouble(request.getParameter("first_operand"));
        double second_operand = Double.parseDouble(request.getParameter("second_operand"));
        String operator = request.getParameter("operator");

        double result = 0;

        if ("+".equals(operator)) {
            result = first_operand + second_operand;
        }
        if ("-".equals(operator)) {
            result = first_operand - second_operand;
        }
        if ("*".equals(operator)) {
            result = first_operand * second_operand;
        }
        if ("/".equals(operator)) {
            result = first_operand / second_operand;
        }

        writer.println("<h1>Result: </h1> " + result);
    }
}
