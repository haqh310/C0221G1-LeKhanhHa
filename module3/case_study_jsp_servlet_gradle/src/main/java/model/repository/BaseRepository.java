package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaseRepository {
    public Connection connectDataBase() {
        final String URL = "jdbc:mysql://localhost:3306/case_study_2?useSSL=false";
        final String USER = "root";
        final String PASSWORD = "lekhanhha";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                // tạo 1 kết nối
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
