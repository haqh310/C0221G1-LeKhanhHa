package model.repository;

import model.bean.User.User;
import model.bean.User.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private BaseRepository repository = new BaseRepository();
    private final String SELECT_USER = "select * from user";
    private final String SELECT_USER_ROLE = "select * from user_role where username=?"
    public List<User> findUser() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = repository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement(SELECT_USER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String username= resultSet.getString("username");
                String password= resultSet.getString("password");
                users.add(new User(username,password));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public UserRole selectUserRole(String name){

    }
}
