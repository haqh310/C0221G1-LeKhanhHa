import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet",value = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        float price = Float.parseFloat(request.getParameter("price"));
        float percent = Float.parseFloat(request.getParameter("percent"));
        double amount = price * percent * 0.01;
        request.setAttribute("product",product);
        request.setAttribute("amount",amount);
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request,response);
    }
}
