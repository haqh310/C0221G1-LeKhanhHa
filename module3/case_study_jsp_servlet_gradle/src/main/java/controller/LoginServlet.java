package controller;

import model.bean.User.User;
import model.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = employeeService.findAllUser();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        boolean check = false;
        for(User user1 : users){
            if(user1.getUsername().equals(username) && user1.getPassword().equals(password)){
                check=true;
                break;
            }
        }
        if(check){
            HttpSession session = request.getSession();
            session.setAttribute("account",username);

            Cookie u = new Cookie("username",username);
            Cookie p = new Cookie("password",password);
            u.setMaxAge(60*60);
            if(remember != null){
                p.setMaxAge(60*60);
            }
           else {
                p.setMaxAge(0);
            }
            response.addCookie(u);
            response.addCookie(p);

            response.sendRedirect("index.jsp");
        }else {
            request.setAttribute("message","wrong username or password");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie arr[] = request.getCookies();
        if(arr !=null){
            for(Cookie o : arr){
                if(o.getName().equals("username")){
                    request.setAttribute("username",o.getValue());
                }
                if(o.getName().equals("password")){
                    request.setAttribute("password",o.getValue());
                }
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
