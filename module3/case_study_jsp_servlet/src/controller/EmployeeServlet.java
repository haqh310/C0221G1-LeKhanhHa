package controller;

import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.service.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employees"})
public class EmployeeServlet extends HttpServlet {
    private EmployeeServiceImpl employeeService;
    private List<Position> positions;
    private List<EducationDegree> educationDegrees;
    private List<Division> divisions;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl();
        positions = employeeService.findAllPosition();
        educationDegrees = employeeService.findAllEducationDegree();
        divisions = employeeService.findAllDivision();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
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
                viewEmployee(request, response);
                break;
            default:
                listEmployee(request, response);
                break;
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = this.employeeService.findAll();
        request.setAttribute("employees", employees);
        request.setAttribute("positions", positions);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("divisions", divisions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list_employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("positions", positions);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("divisions", divisions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create_employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        int employee_id = this.employeeService.findAll().size() + 1;
        String employee_name = request.getParameter("employee_name");
        Date employee_birthday = Date.valueOf(request.getParameter("employee_birthday"));
        String employee_id_card = request.getParameter("employee_id_card");
        double employee_salary = Double.parseDouble(request.getParameter("employee_salary"));
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));
        String username = request.getParameter("username");
        Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username);
        this.employeeService.save(employee);
        request.setAttribute("message", "New employee was created");
        request.setAttribute("positions", positions);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("divisions", divisions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create_employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        Employee employee = this.employeeService.findById(employee_id);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("employee", employee);
            request.setAttribute("positions", positions);
            request.setAttribute("educationDegrees", educationDegrees);
            request.setAttribute("divisions", divisions);
            dispatcher = request.getRequestDispatcher("view/employee/edit_employee.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        Employee employee = this.employeeService.findById(employee_id);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            employee.setEmployee_name(request.getParameter("employee_name"));
            employee.setEmployee_birthday(Date.valueOf(request.getParameter("employee_birthday")));
            employee.setEmployee_id_card(request.getParameter("employee_id_card"));
            employee.setEmployee_salary(Double.parseDouble(request.getParameter("employee_salary")));
            employee.setEmployee_phone(request.getParameter("employee_phone"));
            employee.setEmployee_email(request.getParameter("employee_email"));
            employee.setEmployee_address(request.getParameter("employee_address"));
            employee.setPosition_id(Integer.parseInt(request.getParameter("position_id")));
            employee.setEducation_degree_id(Integer.parseInt(request.getParameter("education_degree_id")));
            employee.setDivision_id(Integer.parseInt(request.getParameter("division_id")));
            employee.setUsername(request.getParameter("username"));
            this.employeeService.update(employee_id, employee);

            request.setAttribute("message", "Employee was updated");
            request.setAttribute("employee", employee);
            request.setAttribute("positions", positions);
            request.setAttribute("educationDegrees", educationDegrees);
            request.setAttribute("divisions", divisions);
            dispatcher = request.getRequestDispatcher("view/employee/edit_employee.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        Employee employee = this.employeeService.findById(employee_id);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.employeeService.remove(employee_id);
            try {
                response.sendRedirect("/employees");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void viewEmployee(HttpServletRequest request, HttpServletResponse response) {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        Employee employee = this.employeeService.findById(employee_id);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("view/employee/view_employee.jsp");
            request.setAttribute("employee", employee);
            request.setAttribute("positions", positions);
            request.setAttribute("educationDegrees", educationDegrees);
            request.setAttribute("divisions", divisions);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String employee_name = request.getParameter("employee_name");
        List<Employee> employees = this.employeeService.findByName(employee_name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list_employee.jsp");
        request.setAttribute("employees", employees);
        request.setAttribute("positions", positions);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("divisions", divisions);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
