package com.example.m3phuctanthithuchanhlan2.repository;

import com.example.m3phuctanthithuchanhlan2.model.PayType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayTypeRepositoryImpl implements IBaseRepository<PayType>{
    private static final String SELECT_ALL_PAYTYPE = "SELECT * FROM pay_type;";
    @Override
    public List<PayType> findAll() {
        List<PayType> payTypes = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PAYTYPE);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                payTypes.add(new PayType(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return payTypes;
    }

    @Override
    public void insert(PayType payType) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(PayType payType) throws SQLException {
        return false;
    }

    @Override
    public PayType getById(int id) {
        return null;
    }

    @Override
    public List<PayType> findByName(String idFind, String nameFind, String phoneNumberFind) {
        return null;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
