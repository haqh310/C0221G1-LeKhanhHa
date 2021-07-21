package controller;

import model.bean.NhanVien;
import model.service.NhanVienService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.servlet.annotation.WebServlet(name = "NhanVienServlet" , urlPatterns = {"","/nhan_vien"})
public class NhanVienServlet extends javax.servlet.http.HttpServlet {
    NhanVienService service = new NhanVienService();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNhanVien(request, response);
                break;
            case "delete":
                deleteNhanVien(request, response);
                break;
            case "edit":
                updateNhanVien(request, response);
                break;
            default:
                break;
        }
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
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

    private void list(HttpServletRequest request, HttpServletResponse response,String message) {
        List<NhanVien> nhanViens = service.selectAll();
        request.setAttribute("nhanViens",nhanViens);
        request.setAttribute("message",message);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien nhanVien = service.selectById(id);
        request.setAttribute("nhanVien",nhanVien);
        try {
            request.getRequestDispatcher("view/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createNhanVien(HttpServletRequest request, HttpServletResponse response) {
        String ten =request.getParameter("ten");
        String ngaySinh = request.getParameter("ngaySinh");
        NhanVien nhanVien = new NhanVien(ten,ngaySinh);
        Map<String, String> mapMsg =service.insert(nhanVien);
        if(mapMsg.isEmpty()){
            request.setAttribute("message","Them moi thanh cong");
        }
        else {
            request.setAttribute("msgTen", mapMsg.get("ten"));
            request.setAttribute("msgNgaySinh", mapMsg.get("ngaySinh"));
            request.setAttribute("nhanVien",nhanVien);
        }
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien nhanVien = service.selectById(id);
        nhanVien.setTen(request.getParameter("ten"));
        nhanVien.setNgaySinh(request.getParameter("ngaySinh"));
        Map<String, String> mapMsg =service.update(nhanVien);
        if(mapMsg.isEmpty()){
            request.setAttribute("message","Cap nhat thanh cong");
        }
        else {
            request.setAttribute("msgTen", mapMsg.get("ten"));
            request.setAttribute("msgNgaySinh", mapMsg.get("ngaySinh"));
            request.setAttribute("nhanVien",nhanVien);
        }
        try {
            request.getRequestDispatcher("view/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = service.delete(id);
        String message=null;
       if(check){
           message="Nhan vien da xoa";
       }else {
           message="Xoa that bai";
       }
       list(request,response,message);
    }

}
