package com.example.furamamanagement.controller;

import com.example.furamamanagement.model.*;
import com.example.furamamanagement.service.rent_type.IRentTypeService;
import com.example.furamamanagement.service.rent_type.RentTypeServiceImpl;
import com.example.furamamanagement.service.service.IServiceService;
import com.example.furamamanagement.service.service.ServiceServiceImpl;
import com.example.furamamanagement.service.service_type.IServiceTypeService;
import com.example.furamamanagement.service.service_type.ServiceTypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServiceServlet", value = "/service")
public class ServiceServlet extends HttpServlet {
    IServiceService serviceService;
    IRentTypeService rentTypeService;
    IServiceTypeService serviceTypeService;
    public void init() {
        serviceService = new ServiceServiceImpl();
        rentTypeService = new RentTypeServiceImpl();
        serviceTypeService = new ServiceTypeServiceImpl();
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
                    deleteService(request, response);
                    break;
                case "view":
                    viewService(request, response);
                    break;
                default:
                    listServices(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listServices(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.selectAllServices();
        List<RentType> rentTypeList = rentTypeService.selectAllRentTypes();
        List<ServiceType> serviceTypeList = serviceTypeService.selectAllServiceTypes();

        request.setAttribute("serviceList", serviceList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceService.deleteService(id);

        List<Service> serviceList = serviceService.selectAllServices();
        List<RentType> rentTypeList = rentTypeService.selectAllRentTypes();
        List<ServiceType> serviceTypeList = serviceTypeService.selectAllServiceTypes();

        request.setAttribute("serviceList", serviceList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void viewService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = serviceService.getServiceById(id);
        List<RentType> rentTypeList = rentTypeService.selectAllRentTypes();
        List<ServiceType> serviceTypeList = serviceTypeService.selectAllServiceTypes();

        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.setAttribute("service", service);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/view.jsp");
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
        Service service = serviceService.getServiceById(id);
        List<RentType> rentTypeList = rentTypeService.selectAllRentTypes();
        List<ServiceType> serviceTypeList = serviceTypeService.selectAllServiceTypes();

        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.setAttribute("service", service);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = rentTypeService.selectAllRentTypes();
        List<ServiceType> serviceTypeList = serviceTypeService.selectAllServiceTypes();

        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/create.jsp");
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
                    insertService(request, response);
                    break;
                case "edit":
                    updateService(request, response);
                    break;
                case "find":
                    findService(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void findService(HttpServletRequest request, HttpServletResponse response) {
        String nameFind = request.getParameter("input_find");
        String rentTypeFind = request.getParameter("rentTypeFind");
        String serviceTypeFind = request.getParameter("serviceTypeFind");

        List<RentType> rentTypeList = rentTypeService.selectAllRentTypes();
        List<ServiceType> serviceTypeList = serviceTypeService.selectAllServiceTypes();
        List<Service> serviceList = serviceService.findByNameRentService(nameFind, rentTypeFind, serviceTypeFind);

        request.setAttribute("serviceList", serviceList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double rentCost = Double.parseDouble(request.getParameter("rent_cost"));
        int peopleMax = Integer.parseInt(request.getParameter("people_max"));
        int rentType = Integer.parseInt(request.getParameter("rent_type"));
        int serviceType = Integer.parseInt(request.getParameter("service_type"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOtherConvenience = request.getParameter("description_other_convenience");
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int floor = Integer.parseInt(request.getParameter("floor"));

        Service service = new Service(id, name, area, rentCost, peopleMax, rentType, serviceType, standardRoom, descriptionOtherConvenience, poolArea, floor);
        serviceService.updateService(service);
        request.setAttribute("message", "Update new service successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws SQLException{
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double rentCost = Double.parseDouble(request.getParameter("rent_cost"));
        int peopleMax = Integer.parseInt(request.getParameter("people_max"));
        int rentType = Integer.parseInt(request.getParameter("rent_type"));
        int serviceType = Integer.parseInt(request.getParameter("service_type"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOtherConvenience = request.getParameter("description_other_convenience");
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int floor = Integer.parseInt(request.getParameter("floor"));

        Service newService = new Service(name, area, rentCost, peopleMax, rentType, serviceType, standardRoom, descriptionOtherConvenience, poolArea, floor);
        Map<String, String> errorMap =  serviceService.insertService(newService);
        String message = "Create new service successfully";
        if (!errorMap.isEmpty()) {
            request.setAttribute("area", area);
            request.setAttribute("errorMap", errorMap);
            message = "Create new service failed";
        }

        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
