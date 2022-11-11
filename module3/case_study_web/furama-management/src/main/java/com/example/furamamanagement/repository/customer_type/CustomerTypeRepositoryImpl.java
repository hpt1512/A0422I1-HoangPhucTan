package com.example.furamamanagement.repository.customer_type;

import com.example.furamamanagement.model.CustomerType;
import com.example.furamamanagement.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements ICustomerTypeRepository {
    private static final String SELECT_ALL_CUSTOMER_TYPES = "SELECT * FROM loai_khach;";
    private static final String SELECT_CUSTOMER_TYPES_BY_ID = "select * from loai_khach where ma_loai_khach = ?;";
    @Override
    public List<CustomerType> selectAllCustomerTypes() {
        List<CustomerType> customerTypes = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPES);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("ma_loai_khach");
                String name = rs.getString("ten_loai_khach");

                customerTypes.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerTypes;
    }

    @Override
    public CustomerType getCustomerTypeById(int id) {
        CustomerType customerType = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPES_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("ten_loai_khach");
                customerType = new CustomerType(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerType;
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
