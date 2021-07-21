package controller;

import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.bean.service.Service;
import model.repository.ContractRepository;
import model.service.IService;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.EmployeeServiceImpl;
import model.service.impl.ServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contracts")
public class ContractServlet extends HttpServlet {
    private ContractRepository contractRepository = new ContractRepository();
    IService<Customer> customerService = new CustomerServiceImpl();
    IService<Employee> employeeService = new EmployeeServiceImpl();
    IService<Service> serviceImpl = new ServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action) {
            case "create_contract":
                createContract(request, response);
                break;
            case "create_contract_detail":
                createContractDetail(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action) {
            case "create_contract":
                showCreateContractFrom(request, response);
                break;
            case "create_contract_detail":
                showCreateContractDetailFrom(request,response);
            default:
                listCustomerContract(request, response);
        }
    }

    private void listCustomerContract(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list_customer_contract.jsp");
        List<String[]> list =contractRepository.findCustomerContract();
        request.setAttribute("listCustomer", list);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateContractFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/create_contract.jsp");
        request.setAttribute("employees", employeeService.findAll());
        request.setAttribute("customers", customerService.findAll());
        request.setAttribute("services", serviceImpl.findAll());
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        Date contract_start_date = Date.valueOf(request.getParameter("contract_start_date"));
        Date contract_end_date = Date.valueOf(request.getParameter("contract_end_date"));
        double contract_deposit = Double.parseDouble(request.getParameter("contract_deposit"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        double contract_total_money=0;
        for(Service service : serviceImpl.findAll()){
            if(service.getService_id() == service_id){
                contract_total_money= service.getService_cost();
            }
        }
        Contract contract = new Contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id);
        contractRepository.insertContract(contract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/create_contract.jsp");
        request.setAttribute("message", "New contract  was created!!!");
        request.setAttribute("employees", employeeService.findAll());
        request.setAttribute("customers", customerService.findAll());
        request.setAttribute("services", serviceImpl.findAll());
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreateContractDetailFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/create_contract_detail.jsp");
        request.setAttribute("contracts", contractRepository.findAllContract());
        request.setAttribute("attach_services",contractRepository.findAllAttachService() );
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createContractDetail(HttpServletRequest request, HttpServletResponse response){
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        int attach_service_id = Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        contractRepository.insertContractDetail(new ContractDetail(contract_id, attach_service_id, quantity));
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/create_contract_detail.jsp");
        request.setAttribute("contracts", contractRepository.findAllContract());
        request.setAttribute("attach_services",contractRepository.findAllAttachService() );
        request.setAttribute("message", "New contract detail was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
