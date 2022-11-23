package com.example.furamamanagement.repository.customer;

import com.example.furamamanagement.model.Customer;
import com.example.furamamanagement.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM khach_hang;";
    private static final String INSERT_CUSTOMER_SQL = "insert into khach_hang (ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi)\n" +
            "\tvalues \t(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_CUSTOMER_SQL = "delete from khach_hang where ma_khach_hang = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update khach_hang set ma_loai_khach = ?, ho_ten = ?, ngay_sinh = ?, gioi_tinh =?, so_cmnd = ?, so_dien_thoai = ?, email = ?, dia_chi = ?\n" +
            "where ma_khach_hang = ?;";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from khach_hang where ma_khach_hang = ?;";
    private static final String SELECT_CUSTOMER_BY_NAME = "select * from khach_hang\n" +
            "where ho_ten like concat('%', ?, '%');";
    @Override
    public List<Customer> selectAllCustomers() {
            List<Customer> customers = new ArrayList<>();
            try (Connection connection = BaseRepository.getConnectDB();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
                System.out.println(preparedStatement);
                // Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Process the ResultSet object.
                while (rs.next()) {
                    int id = rs.getInt("ma_khach_hang");
                    int idTypeCustomer = rs.getInt("ma_loai_khach");
                    String name = rs.getString("ho_ten");
                    Date birthday = rs.getDate("ngay_sinh");
                    boolean gender = rs.getBoolean("gioi_tinh");
                    String cmnd = rs.getString("so_cmnd");
                    String phoneNumber = rs.getString("so_dien_thoai");
                    String email = rs.getString("email");
                    String address = rs.getString("dia_chi");
                    customers.add(new Customer(id, idTypeCustomer, name, birthday, gender, cmnd, phoneNumber, email, address));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return customers;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getName());

            java.sql.Date sqlDate = new java.sql.Date(customer.getBirthday().getTime());

            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setBoolean(4, customer.isGender());
            preparedStatement.setString(5, customer.getCmnd());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            statement.setInt(1, customer.getCustomerTypeId());
            statement.setString(2, customer.getName());

            java.sql.Date sqlDate = new java.sql.Date(customer.getBirthday().getTime());

            statement.setDate(3, sqlDate);
            statement.setBoolean(4, customer.isGender());
            statement.setString(5, customer.getCmnd());
            statement.setString(6, customer.getPhoneNumber());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getAddress());
            statement.setInt(9, customer.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int customerTypeId = rs.getInt("ma_loai_khach");
                String name = rs.getString("ho_ten");
                Date birthday = rs.getDate("ngay_sinh");
                boolean gender = rs.getBoolean("gioi_tinh");
                String cmnd = rs.getString("so_cmnd");
                String phoneNumber = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                customer = new Customer(id, customerTypeId, name, birthday, gender, cmnd, phoneNumber, email, address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnectDB();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);


            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ma_khach_hang");
                int customerTypeId = rs.getInt("ma_loai_khach");
                String name2 = rs.getString("ho_ten");
                Date birthday = rs.getDate("ngay_sinh");
                boolean gender = rs.getBoolean("gioi_tinh");
                String cmnd = rs.getString("so_cmnd");
                String phoneNumber = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                Customer customer = new Customer(id, customerTypeId, name2, birthday, gender, cmnd, phoneNumber, email, address);
                customers.add(customer);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
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
