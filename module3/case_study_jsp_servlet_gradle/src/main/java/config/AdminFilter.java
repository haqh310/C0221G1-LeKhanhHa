package config;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter  {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession(false);
        if(session == null && session.getAttribute("account") == null){
            response.sendRedirect("/login");
        }else {
            UserRole userRole= (UserRole) session.getAttribute("acc");
            switch (servletPath){
                case "/employees":
                    if(userRole.getRole().getId()==2){
                        chain.doFilter(request, response);
                    }else {
                        request.setAttribute("message", "You are not authorized to make this request");request.setAttribute("err", true);
                        request.getRequestDispatcher("/home").forward(request,response);
                    }
                    break;
                case "/services":
                    chain.doFilter(request, response);
                    break;
                default: chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
