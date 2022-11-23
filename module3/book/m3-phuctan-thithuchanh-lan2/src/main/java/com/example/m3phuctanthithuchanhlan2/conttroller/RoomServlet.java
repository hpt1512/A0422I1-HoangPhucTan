package com.example.m3phuctanthithuchanhlan2.conttroller;

import com.example.m3phuctanthithuchanhlan2.model.PayType;
import com.example.m3phuctanthithuchanhlan2.model.Room;
import com.example.m3phuctanthithuchanhlan2.service.IBaseService;
import com.example.m3phuctanthithuchanhlan2.service.PayTypeServiceImpl;
import com.example.m3phuctanthithuchanhlan2.service.RoomServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "RoomServlet", value = "/room")
public class RoomServlet extends HttpServlet {
    IBaseService<Room> roomService = new RoomServiceImpl();
    IBaseService<PayType> payTypeService = new PayTypeServiceImpl();
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
//                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteRoom(request, response);
                    break;
                case "borrow":
//                    showBorrowForm(request, response);
                    break;
                default:
                    listRoom(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteRoom(HttpServletRequest request, HttpServletResponse response) throws SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        roomService.delete(id);

        List<Room> roomList = roomService.findAll();
        List<PayType> payTypeList = payTypeService.findAll();

        request.setAttribute("roomList", roomList);
        request.setAttribute("payTypeList", payTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/room/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<Room> roomList = roomService.findAll();
        List<PayType> payTypeList = payTypeService.findAll();
        request.setAttribute("roomList", roomList);
        request.setAttribute("payTypeList", payTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/room/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listRoom(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Room> roomList = roomService.findAll();
        List<PayType> payTypeList = payTypeService.findAll();
        request.setAttribute("roomList", roomList);
        request.setAttribute("payTypeList", payTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/room/list.jsp");
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
                    insertRoom(request, response);
                    break;
                case "edit":
                    updateRoom(request, response);
                    break;
                case "find":
                    findRoom(request, response);
                    break;
            }
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
    }

    private void findRoom(HttpServletRequest request, HttpServletResponse response) {
        String idFind = request.getParameter("idFind");
        String nameFind = request.getParameter("nameFind");
        String phoneNumberFind = request.getParameter("phoneNumberFind");
        List<Room> roomList = this.roomService.findByName(idFind, nameFind, phoneNumberFind);

        List<PayType> payTypeList = payTypeService.findAll();
        request.setAttribute("roomList", roomList);
        request.setAttribute("payTypeList", payTypeList);
        try {
            request.getRequestDispatcher("views/room/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateRoom(HttpServletRequest request, HttpServletResponse response) {
    }

    private void insertRoom(HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException{
        String username = request.getParameter("username");
        String phoneNumber = request.getParameter("phoneNumber");
        String strDateStart = request.getParameter("dateStart");
        Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(strDateStart);
        int idPay = Integer.parseInt(request.getParameter("idPay"));
        String note = request.getParameter("note");

        Room newRoom = new Room(username, phoneNumber, dateStart, idPay, note);
        roomService.insert(newRoom);

        String message = "Thêm mới thành công";
        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/room/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
