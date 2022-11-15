package com.example.m3phuctanthithuchanh.controller;

import com.example.m3phuctanthithuchanh.model.Book;
import com.example.m3phuctanthithuchanh.model.BorrowCard;
import com.example.m3phuctanthithuchanh.model.Student;
import com.example.m3phuctanthithuchanh.service.BookServiceImpl;
import com.example.m3phuctanthithuchanh.service.BorrowCardServiceImpl;
import com.example.m3phuctanthithuchanh.service.IBaseService;
import com.example.m3phuctanthithuchanh.service.StudentServiceImpl;

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
import java.util.Map;

@WebServlet(name = "BorrowCardServlet", value = "/borrow-card")
public class BorrowCardServlet extends HttpServlet {
    IBaseService<BorrowCard> borrowCardService = new BorrowCardServiceImpl();
    IBaseService<Book> bookService = new BookServiceImpl();
    IBaseService<Student> studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
//                    showNewForm(request, response);
                    break;
                case "edit":
//                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteBorrowCard(request, response);
                    break;
                default:
                    listBorrowCard(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteBorrowCard(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    }

    private void listBorrowCard(HttpServletRequest request, HttpServletResponse response) {
        List<BorrowCard> borrowCardList = borrowCardService.findAll();

        request.setAttribute("borrowCardList", borrowCardList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/borrow_card/list.jsp");
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
                    insertBorrowCard(request, response);
                    break;
//                case "edit":
//                    updateCustomer(request, response);
//                    break;
//                case "find":
//                    findCustomer(request, response);
//                    break;
            }
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertBorrowCard(HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException{
        String idBorrow = request.getParameter("idBorrow");
        int idBook = Integer.parseInt(request.getParameter("bookName"));
        int idStudent = Integer.parseInt(request.getParameter("studentName"));

        String strDateStart = request.getParameter("dateStart");
        Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(strDateStart);

        String strDateEnd = request.getParameter("dateEnd");
        Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(strDateEnd);

        BorrowCard borrowCard = new BorrowCard(idBorrow, idBook, idStudent, dateStart, dateEnd);
        borrowCardService.insert(borrowCard);
        String message = "Create new borrowCard successfully";

        List<Book> bookList = bookService.findAll();
        request.setAttribute("bookList", bookList);

        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/book/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
