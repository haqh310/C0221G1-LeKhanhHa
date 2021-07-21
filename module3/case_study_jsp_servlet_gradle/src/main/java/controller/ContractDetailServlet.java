package controller;

import model.bean.contract.AttachService;
import model.bean.contract.ContractDetail;
import model.service.Interface.IContractDetailService;
import model.service.impl.ContractDetailServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contract_details")
public class ContractDetailServlet extends HttpServlet {
    private IContractDetailService contractDetailServiceImpl = new ContractDetailServiceImpl();
    List<AttachService> attachServices = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        attachServices = contractDetailServiceImpl.findAllAttachService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContractDetail(request, response);
                break;
            case "edit":
                updateContractDetail(request, response);
                break;
            case "delete":
                deleteContractDetail(request, response);
                break;
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
            case "view":
                listContractDetail(request, response);
                break;
            case "create":
                showCreateFrom(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
        }
    }

    private void listContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        List<ContractDetail> contractDetails = contractDetailServiceImpl.findListContractDetail(contract_id);
        request.setAttribute("contract_id", contract_id);
        request.setAttribute("contractDetails", contractDetails);
        request.setAttribute("attachServices", attachServices);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/contract_detail/list_contract_detail.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/contract_detail/create_contract_detail.jsp");
        request.setAttribute("contract_id", contract_id);
        request.setAttribute("attach_services", attachServices);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        int attach_service_id = Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        boolean check = this.contractDetailServiceImpl.insertContractDetail(new ContractDetail(contract_id, attach_service_id, quantity));
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract_detail/create_contract_detail.jsp");
        request.setAttribute("contract_id", contract_id);
        request.setAttribute("attach_services", attachServices);
        request.setAttribute("message", "New contract detail was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int contract_detail_id = Integer.parseInt(request.getParameter("contract_detail_id"));
        ContractDetail contractDetail = contractDetailServiceImpl.findContractDetail(contract_detail_id);
        RequestDispatcher dispatcher;
        if (contractDetail == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("view/contract_detail/edit_contract_detail.jsp");
            request.setAttribute("contractDetail", contractDetail);
            request.setAttribute("attachServices", attachServices);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void updateContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contract_detail_id = Integer.parseInt(request.getParameter("contract_detail_id"));
        ContractDetail contractDetail = contractDetailServiceImpl.findContractDetail(contract_detail_id);
        RequestDispatcher dispatcher;
        if (contractDetail == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            contractDetail.setAttach_service_id(Integer.parseInt(request.getParameter("attach_service_id")));
            contractDetail.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            this.contractDetailServiceImpl.updateContractDetail(contract_detail_id, contractDetail);
            dispatcher = request.getRequestDispatcher("view/contract_detail/edit_contract_detail.jsp");
            request.setAttribute("contractDetail", contractDetail);
            request.setAttribute("attachServices", attachServices);
            request.setAttribute("message", "Contract detail was updated!!!");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contract_detail_id = Integer.parseInt(request.getParameter("contract_detail_id"));
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        this.contractDetailServiceImpl.deleteContractDetail(contract_detail_id);
        try {
            response.sendRedirect("/contract_details?action=view&contract_id=" + contract_id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
