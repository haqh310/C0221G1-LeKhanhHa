package controller;

import model.bean.contract.AttachService;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.service.Interface.ICustomerService;
import model.service.Interface.IEmployeeService;
import model.service.Interface.IServices;
import model.service.impl.ContractDetailServiceImpl;
import model.service.impl.ContractServiceImpl;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contracts")
public class ContractServlet extends HttpServlet {
    private ContractServiceImpl contractServiceImpl = new ContractServiceImpl();
    private ContractDetailServiceImpl contractDetailService = new ContractDetailServiceImpl();
    ICustomerService customerService = new CustomerServiceImpl();
    IEmployeeService employeeService = new EmployeeServiceImpl();
    IServices serviceImpl = new ServiceImpl();
    List<AttachService> attachServices = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        attachServices = contractDetailService.findAllAttachService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request, response);
                break;
            case "delete":
                deleteContract(request, response);
            case "edit":
                updateContract(request, response);
            case "search":
                searchContract(request,response);
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
                showCreateContractFrom(request, response);
                break;
            case "view":
                showContract(request, response);
            case "edit":
                showEditContractForm(request, response);
            default:
                listCustomerContract(request, response, null);
        }
    }


    private void listCustomerContract(HttpServletRequest request, HttpServletResponse response, String message) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list_customer_contract.jsp");
        List<String[]> list = contractServiceImpl.findCustomerContract();
        request.setAttribute("listCustomer", list);
        request.setAttribute("message", message);
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
        Contract contract = new Contract(contract_start_date, contract_end_date, contract_deposit, employee_id, customer_id, service_id);
        boolean check = this.contractServiceImpl.insertContract(contract);
        if(check){
            request.setAttribute("message", "New contract  was created!!!");
        }else {
            request.setAttribute("message", "Create new contract  failed!!!");
        }
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

    private void showContract(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        Contract contract = contractServiceImpl.findContractById(contract_id);
        RequestDispatcher dispatcher;
        if (contract == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/view/contract/view_contract.jsp");
            request.setAttribute("contract", contract);
            request.setAttribute("employees", employeeService.findAll());
            request.setAttribute("customers", customerService.findAll());
            request.setAttribute("services", serviceImpl.findAll());
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditContractForm(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        Contract contract = contractServiceImpl.findContractById(contract_id);
        List<ContractDetail> contractDetails = contractDetailService.findListContractDetail(contract_id);
        RequestDispatcher dispatcher;
        if (contract == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/view/contract/edit_contract.jsp");
            request.setAttribute("contract", contract);
            request.setAttribute("employees", employeeService.findAll());
            request.setAttribute("customers", customerService.findAll());
            request.setAttribute("services", serviceImpl.findAll());

        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateContract(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        Contract contract = contractServiceImpl.findContractById(contract_id);
        List<ContractDetail> contractDetails = contractDetailService.findListContractDetail(contract_id);
        RequestDispatcher dispatcher;
        if (contract == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            contract.setContract_start_date(Date.valueOf(request.getParameter("contract_start_date")));
            contract.setContract_end_date(Date.valueOf(request.getParameter("contract_end_date")));
            contract.setContract_deposit(Double.parseDouble(request.getParameter("contract_deposit")));
            contract.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
            contract.setCustomer_id(Integer.parseInt(request.getParameter("customer_id")));
            contract.setService_id(Integer.parseInt(request.getParameter("service_id")));
            boolean check = contractServiceImpl.updateContract(contract_id, contract);
            if(check){
                request.setAttribute("message","Contract information was update");
            }else {
                request.setAttribute("message","Update contract information failed!!!");
            }
            dispatcher = request.getRequestDispatcher("/view/contract/edit_contract.jsp");
            request.setAttribute("contract", contract);
            request.setAttribute("contractDetails", contractDetails);
            request.setAttribute("attachServices", attachServices);
            request.setAttribute("employees", employeeService.findAll());
            request.setAttribute("customers", customerService.findAll());
            request.setAttribute("services", serviceImpl.findAll());
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        boolean check = contractServiceImpl.deleteContract(contract_id);
        String message;
        if (check) {
            message = "Success deleted customer";
        } else {
            message = "Deleted customer fail";
        }
        listCustomerContract(request, response, message);
    }

    private void searchContract(HttpServletRequest request, HttpServletResponse response) {
        String customer_name = request.getParameter("customer_name");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list_customer_contract.jsp");
        List<String[]> list = contractServiceImpl.findContractByName(customer_name);
        request.setAttribute("listCustomer", list);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
