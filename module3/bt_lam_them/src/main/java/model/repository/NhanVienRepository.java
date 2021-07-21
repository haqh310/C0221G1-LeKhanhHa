package model.repository;

import model.bean.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL = "select * from nhan_vien";
    private final String SELECT_BY_ID = "select * from nhan_vien where id=?";
    private final String INSERT_INTO = "insert into nhan_vien(ten,ngay_sinh) values(?,?)";
    private final String UPDATE = "update nhan_vien set ten=?,ngay_sinh=? where id=?";
    private final String DELETE ="delete from nhan_vien where id=?";

    public List<NhanVien> selectAll(){
        Connection connection = baseRepository.connectDataBase();
        List<NhanVien> nhanViens = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String ten = resultSet.getString("ten");
                String ngaySinh = resultSet.getString("ngay_sinh");
                nhanViens.add(new NhanVien(id,ten,ngaySinh));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanViens;
    }
    public NhanVien selectById(int id){
        Connection connection = baseRepository.connectDataBase();
        NhanVien nhanVien=null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String ten = resultSet.getString("ten");
                String ngaySinh = resultSet.getString("ngay_sinh");
                nhanVien = new NhanVien(id,ten,ngaySinh);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanVien;
    }
    public boolean insert(NhanVien nhanVien){
        boolean rowInsert=false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO);
            statement.setString(1,nhanVien.getTen());
            statement.setString(2,nhanVien.getNgaySinh());
            rowInsert = statement.executeUpdate() >0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }
    public boolean update(NhanVien nhanVien){
        boolean rowUpdate=false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1,nhanVien.getTen());
            statement.setString(2,nhanVien.getNgaySinh());
            statement.setInt(3,nhanVien.getId());
            rowUpdate = statement.executeUpdate() >0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }
    public boolean delete(int id){
        boolean rowDelete=false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1,id);
            rowDelete = statement.executeUpdate() >0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}
