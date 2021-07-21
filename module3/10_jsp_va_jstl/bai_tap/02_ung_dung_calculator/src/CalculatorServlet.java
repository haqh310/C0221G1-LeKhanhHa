import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet",value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first_op = Float.parseFloat(request.getParameter("first_op"));
        float second_op = Float.parseFloat(request.getParameter("second_op"));
        String operator = request.getParameter("operator");
        double result=0;
        try{
            result=Calculator.calculate(first_op, second_op, operator);
            request.setAttribute("first_op",first_op);
            request.setAttribute("operator",operator);
            request.setAttribute("second_op",second_op);
            request.setAttribute("result",result);
        }catch (Exception e){
            request.setAttribute("message","Khong the chia cho 0");
            System.out.println(e.getMessage());
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request,response);
    }
}