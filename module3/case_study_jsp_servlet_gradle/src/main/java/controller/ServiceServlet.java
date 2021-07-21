package controller;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;
import model.service.Interface.IServices;
import model.service.impl.ServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {
    private IServices servicesImp;
    private List<ServiceType> serviceTypes;
    private List<RentType> rentTypes;

    @Override
    public void init() throws ServletException {
        servicesImp = new ServiceImpl();
        serviceTypes = servicesImp.findAllServiceType();
        rentTypes = servicesImp.findAllRentType();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
            case "edit":
                updateService(request, response);
                break;
            case "delete":
                deleteService(request, response);
                break;
            case "search":
                searchService(request, response);
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFrom(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "view":
                viewService(request, response);
                break;
            default:
                listService(request, response, null);
                break;
        }
    }


    private void listService(HttpServletRequest request, HttpServletResponse response, String message) {
        List<Service> services = this.servicesImp.findAll();
        request.setAttribute("services", services);
        request.setAttribute("rentTypes", rentTypes);
        request.setAttribute("serviceTypes", serviceTypes);
        request.setAttribute("message",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list_service.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("rentTypes", rentTypes);
        request.setAttribute("serviceTypes", serviceTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create_service.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String service_code = request.getParameter("service_code");
        String service_name = request.getParameter("service_name");
        int service_area = Integer.parseInt(request.getParameter("service_area"));
        double service_cost = Double.parseDouble(request.getParameter("service_cost"));
        int service_max_people = Integer.parseInt(request.getParameter("service_max_people"));
        int rent_type_id = Integer.parseInt(request.getParameter("rent_type_id"));
        int service_type_id = Integer.parseInt(request.getParameter("service_type_id"));
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        String pool_area = request.getParameter("pool_area");
        String number_of_floors = request.getParameter("number_of_floors");
        Service service = new Service(service_code, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors);
        List<String> messages = this.servicesImp.insert(service);
        if(messages.size() == 6){
            request.setAttribute("service",service);
        }
        request.setAttribute("messages",messages);
        request.setAttribute("rentTypes", rentTypes);
        request.setAttribute("serviceTypes", serviceTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create_service.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Service service = this.servicesImp.findById(service_id);
        RequestDispatcher dispatcher;
        if (service == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("view/service/edit_service.jsp");
            request.setAttribute("service", service);
            request.setAttribute("rentTypes", rentTypes);
            request.setAttribute("serviceTypes", serviceTypes);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) {
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Service service = this.servicesImp.findById(service_id);
        RequestDispatcher dispatcher;
        if (service == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            service.setService_name(request.getParameter("service_name"));
            service.setService_area(Integer.parseInt(request.getParameter("service_area")));
            service.setService_cost(Double.parseDouble(request.getParameter("service_cost")));
            service.setService_max_people(Integer.parseInt(request.getParameter("service_max_people")));
            service.setRent_type_id(Integer.parseInt(request.getParameter("rent_type_id")));
            service.setService_type_id(Integer.parseInt(request.getParameter("service_type_id")));
            service.setStandard_room(request.getParameter("standard_room"));
            service.setDescription_other_convenience(request.getParameter("description_other_convenience"));
            service.setPool_area(request.getParameter("pool_area"));
            service.setNumber_of_floors(request.getParameter("number_of_floors"));
            List<String> messages = this.servicesImp.insert(service);
            request.setAttribute("messages",messages);
            request.setAttribute("service", service);
            request.setAttribute("rentTypes", rentTypes);
            request.setAttribute("serviceTypes", serviceTypes);
            dispatcher = request.getRequestDispatcher("view/service/edit_service.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewService(HttpServletRequest request, HttpServletResponse response) {
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Service service = this.servicesImp.findById(service_id);
        RequestDispatcher dispatcher;
        if (service == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("view/service/view_service.jsp");
            request.setAttribute("service",service);
            request.setAttribute("rentTypes", rentTypes);
            request.setAttribute("serviceTypes", serviceTypes);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("service_name");
        List<Service> services = this.servicesImp.findByName(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list_service.jsp");
        request.setAttribute("services", services);
        request.setAttribute("rentTypes", rentTypes);
        request.setAttribute("serviceTypes", serviceTypes);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        boolean check = this.servicesImp.remove(service_id);
        String message;
        if (check) {
            message = "Success deleted customer";
        } else {
            message = "Deleted customer fail";
        }
        listService(request,response,message);
    }

}
