package com.codegym.controller;


import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.user.User;
import com.codegym.model.service.IEmployeeService;
import com.codegym.model.service.IUserService;
import com.codegym.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;


@Controller
@SessionAttributes("user")
public class HomeController {

    @ModelAttribute("user")
    public User setUser() {
        return new User();
    }


    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/", "/home"})
    public String goHome() {
        return "home";
    }

    @GetMapping(value = "/login")
    public String loginPage(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "login";
    }

    @GetMapping(value = "/login_success")
    public String loginSuccess(@SessionAttribute("user") User user,
                               @CookieValue(value = "setUser", defaultValue = "") String setUser,
                               HttpServletResponse response,
                               Principal principal) {
        if (principal != null) {
            setUser = principal.getName();
            user.setEmployee(this.userService.findUser(setUser).getEmployee());
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
        }
        return "home";
    }

    @GetMapping(value = "/403")
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }
        return "403Page";
    }
}
