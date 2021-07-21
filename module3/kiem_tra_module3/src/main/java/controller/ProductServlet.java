package controller;

import model.bean.DanhMuc;
import model.bean.SanPham;
import model.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = {"","/products"})
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    List<DanhMuc> danhMucs=new ArrayList<>();
    @Override
    public void init() throws ServletException {
        danhMucs = productService.lisDanhMuc();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "search":
                searchProduct(request,response);
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
                showCreate(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            default:
                list(request, response,null);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response, String message) {
        List<SanPham> sanPhams = productService.findAll();
        request.setAttribute("sanPhams",sanPhams);
        request.setAttribute("danhMucs",danhMucs);
        request.setAttribute("message",message);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("danhMucs",danhMucs);
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("ten");
        double gia = Double.parseDouble(request.getParameter("gia"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String mauSac =request.getParameter("mauSac");
        String moTa = request.getParameter("moTa");
        int idDanhMuc = Integer.parseInt(request.getParameter("idDanhMuc"));
        SanPham sanPham = new SanPham(ten,gia,soLuong,mauSac,moTa,idDanhMuc);
        boolean check = productService.insert(sanPham);
        if(check){
            String message ="New product was created";
            list(request,response,message);
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = productService.findById(id);
        request.setAttribute("sanPham",sanPham);
        request.setAttribute("danhMucs",danhMucs);
        try {
            request.getRequestDispatcher("view/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = productService.findById(id);
        sanPham.setTen(request.getParameter("ten"));
        sanPham.setGia(Double.parseDouble(request.getParameter("gia")));
        sanPham.setSoLuong(Integer.parseInt(request.getParameter("soLuong")));
        sanPham.setMauSac(request.getParameter("mauSac"));
        sanPham.setMoTa(request.getParameter("moTa"));
        sanPham.setIdDanhMuc(Integer.parseInt(request.getParameter("idDanhMuc")));
       boolean check = productService.update(sanPham);
       if(check){
           request.setAttribute("message","Product information was updated");
       }
        request.setAttribute("sanPham",sanPham);
        request.setAttribute("danhMucs",danhMucs);
        try {
            request.getRequestDispatcher("view/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
}

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = productService.remove(id);
        String message=null;
        if(check){
            message="Product was delete";
        }else {
            message="Delete product failed";
        }
        list(request,response,message);
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String ten =request.getParameter("ten");
        List<SanPham> sanPhams = productService.findByName(ten);
        request.setAttribute("sanPhams",sanPhams);
        request.setAttribute("danhMucs",danhMucs);
        request.setAttribute("msgSearch",sanPhams.size());
        request.setAttribute("msgTen",ten);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
