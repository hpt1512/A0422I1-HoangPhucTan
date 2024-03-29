package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
    List<User> findByName(String name);
    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;
    List<User> selectAllUsersStore();
    boolean deleteUserStore(int id) throws SQLException;

    boolean updateUserStore(User user) throws SQLException;
}
