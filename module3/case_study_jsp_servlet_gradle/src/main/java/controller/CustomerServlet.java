package controller;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.service.Interface.ICustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customers"})
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService;
    private List<CustomerType> customerTypes;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerServiceImpl();
        customerTypes = customerService.findAllCustomerType();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
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
                viewCustomer(request, response);
                break;
            default:
                listCustomers(request, response, null);
                break;
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response, String message) {
        List<Customer> customers = this.customerService.findAll();
        request.setAttribute("message", message);
        request.setAttribute("customers", customers);
        request.setAttribute("customerTypes", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list_customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerTypes", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create_customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customer_code = request.getParameter("customer_code");
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String customer_name = request.getParameter("customer_name");
        Date customer_birthday = Date.valueOf(request.getParameter("customer_birthday"));
        String customer_gender = request.getParameter("customer_gender");
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");
        Customer customer = new Customer(customer_code,customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
        List<String> messages = this.customerService.insert(customer);
        if(messages.size() ==5){
            request.setAttribute("customer", customer);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create_customer.jsp");
        request.setAttribute("messages",messages);
        request.setAttribute("customerTypes", customerTypes);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        Customer customer = (Customer) this.customerService.findById(customer_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit_customer.jsp");
        request.setAttribute("customer", customer);
        request.setAttribute("customerTypes", customerTypes);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        Customer customer = this.customerService.findById(customer_id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            customer.setCustomer_type_id(Integer.parseInt(request.getParameter("customer_type_id")));
            customer.setCustomer_name(request.getParameter("customer_name"));
            customer.setCustomer_birthday(Date.valueOf(request.getParameter("customer_birthday")));
            customer.setCustomer_gender(request.getParameter("customer_gender"));
            customer.setCustomer_id_card(request.getParameter("customer_id_card"));
            customer.setCustomer_phone(request.getParameter("customer_phone"));
            customer.setCustomer_email(request.getParameter("customer_email"));
            customer.setCustomer_address(request.getParameter("customer_address"));
            List<String> messages = this.customerService.insert(customer);
            request.setAttribute("customer", customer);
            request.setAttribute("messages", messages);
            request.setAttribute("customerTypes", customerTypes);
            dispatcher = request.getRequestDispatcher("view/customer/edit_customer.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        boolean check = this.customerService.remove(customer_id);
        String message;
        if (check) {
            message = "Success deleted customer";
        } else {
            message = "Deleted customer fail";
        }
        listCustomers(request, response, message);
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        Customer customer = (Customer) this.customerService.findById(customer_id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            request.setAttribute("customerTypes", customerTypes);
            dispatcher = request.getRequestDispatcher("view/customer/view_customer.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customer_name = request.getParameter("customer_name");
        List<Customer> customers = this.customerService.findByName(customer_name);
        request.setAttribute("customers", customers);
        request.setAttribute("customerTypes", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list_customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
