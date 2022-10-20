package com.example.product_discount_caculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountServlet", value = "/product_discount")
public class ProductDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String product_description = request.getParameter("product_description");
        double list_price = Double.parseDouble(request.getParameter("list_price"));
        double discount_percent = Double.parseDouble(request.getParameter("discount_percent"));

        double discount_amount = list_price * discount_percent * 0.01;

        writer.println("<h1>KET QUA : </h1>" + discount_amount);
        writer.println("<h2>MO TA : </h2>" + product_description);

    }
}
