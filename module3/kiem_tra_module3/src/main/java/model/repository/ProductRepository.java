package model.repository;

import model.bean.DanhMuc;
import model.bean.SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL = "select * from san_pham";
    private final String SELECT_DANH_MUC = "select * from danh_muc";
    private final String SELECT_BY_ID = "select * from san_pham where id=?";
    private final String SELECT_BY_NAME = "select * from san_pham where ten like ?";
    private final String INSERT = "insert into san_pham(ten,gia,so_luong,mau_sac,mo_ta,id_danh_muc) " +
            "values(?,?,?,?,?,?)";
    private final String UPDATE = "update san_pham set ten=?, gia=?, so_luong=?, mau_sac=?, mo_ta=?, id_danh_muc=? where id=?";
    private final String DELETE = "delete from san_pham where id=?";

    public List<SanPham> selectAll() {
        Connection connection = baseRepository.connectDataBase();
        List<SanPham> sanPhams = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ten = resultSet.getString("ten");
                double gia = resultSet.getDouble("gia");
                int soluong = resultSet.getInt("so_luong");
                String mauSac = resultSet.getString("mau_sac");
                String moTa = resultSet.getString("mo_ta");
                int idDanhMuc = resultSet.getInt("id_danh_muc");
                sanPhams.add(new SanPham(id, ten, gia, soluong, mauSac, moTa, idDanhMuc));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }

    public SanPham selectById(int id) {
        Connection connection = baseRepository.connectDataBase();
        SanPham sanPham = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ten = resultSet.getString("ten");
                double gia = resultSet.getDouble("gia");
                int soluong = resultSet.getInt("so_luong");
                String mauSac = resultSet.getString("mau_sac");
                String moTa = resultSet.getString("mo_ta");
                int idDanhMuc = resultSet.getInt("id_danh_muc");
                sanPham = new SanPham(id, ten, gia, soluong, mauSac, moTa, idDanhMuc);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public List<SanPham> selectByName(String name) {
        Connection connection = baseRepository.connectDataBase();
        List<SanPham> sanPhams = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME);
            statement.setString(1,"%"+name+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ten = resultSet.getString("ten");
                double gia = resultSet.getDouble("gia");
                int soluong = resultSet.getInt("so_luong");
                String mauSac = resultSet.getString("mau_sac");
                String moTa = resultSet.getString("mo_ta");
                int idDanhMuc = resultSet.getInt("id_danh_muc");
                sanPhams.add(new SanPham(id, ten, gia, soluong, mauSac, moTa, idDanhMuc));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }


    public boolean insert(SanPham sanPham) {
        boolean rowInsert = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, sanPham.getTen());
            statement.setDouble(2, sanPham.getGia());
            statement.setInt(3, sanPham.getSoLuong());
            statement.setString(4, sanPham.getMauSac());
            statement.setString(5, sanPham.getMoTa());
            statement.setInt(6, sanPham.getIdDanhMuc());
            rowInsert = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    public boolean update(SanPham sanPham) {
        boolean rowUpdate = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, sanPham.getTen());
            statement.setDouble(2, sanPham.getGia());
            statement.setInt(3, sanPham.getSoLuong());
            statement.setString(4, sanPham.getMauSac());
            statement.setString(5, sanPham.getMoTa());
            statement.setInt(6, sanPham.getIdDanhMuc());
            statement.setInt(7, sanPham.getId());
            rowUpdate = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    public boolean delete(int id) {
        boolean rowDelete = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, id);
            rowDelete = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    public List<DanhMuc> selectDanhMuc() {
        Connection connection = baseRepository.connectDataBase();
        List<DanhMuc> danhMucs = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_DANH_MUC);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ten = resultSet.getString("ten");
                danhMucs.add(new DanhMuc(id, ten));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhMucs;
    }

}
