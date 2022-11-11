package com.example.furamamanagement.repository.employee;

import com.example.furamamanagement.model.Employee;
import com.example.furamamanagement.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM nhan_vien;";
    private static final String INSERT_EMPLOYEE_SQL = "insert into nhan_vien (ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)\n" +
            "\tvalues \t(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_EMPLOYEE_SQL = "delete from nhan_vien where ma_nhan_vien = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update nhan_vien set ho_ten = ?, ngay_sinh = ?, so_cmnd = ?, luong = ?, so_dien_thoai = ?, \n" +
            "\temail = ?, dia_chi = ? , ma_vi_tri = ?, ma_trinh_do = ?, ma_bo_phan = ?\n" +
            "where ma_nhan_vien = ?;";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from nhan_vien where ma_nhan_vien = ?;";
    private static final String SELECT_EMPLOYEE_BY_NAME = "select * from nhan_vien where ho_ten like concat('%', ?, '%');";

    @Override
    public List<Employee> selectAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("ma_nhan_vien");
                String name = rs.getString("ho_ten");
                Date birthday = rs.getDate("ngay_sinh");
                String cmnd = rs.getString("so_cmnd");
                double salary = rs.getDouble("luong");
                String phoneNumber = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                int idPosition = rs.getInt("ma_vi_tri");
                int idEducationDegree = rs.getInt("ma_trinh_do");
                int idDivision = rs.getInt("ma_bo_phan");

                employees.add(new Employee(id, name, birthday, cmnd, salary, phoneNumber, email, address, idPosition, idEducationDegree, idDivision));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEE_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getName());

            java.sql.Date sqlDate = new java.sql.Date(employee.getBirthday().getTime());

            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setString(3, employee.getCmnd());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getIdPosition());
            preparedStatement.setInt(9, employee.getIdEducationDegree());
            preparedStatement.setInt(10, employee.getIdDivision());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
            preparedStatement.setString(1, employee.getName());

            java.sql.Date sqlDate = new java.sql.Date(employee.getBirthday().getTime());

            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setString(3, employee.getCmnd());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getIdPosition());
            preparedStatement.setInt(9, employee.getIdEducationDegree());
            preparedStatement.setInt(10, employee.getIdDivision());
            preparedStatement.setInt(11, employee.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("ho_ten");
                Date birthday = rs.getDate("ngay_sinh");
                String cmnd = rs.getString("so_cmnd");
                double salary = rs.getDouble("luong");
                String phoneNumber = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                int idPosition = rs.getInt("ma_vi_tri");
                int idEducationDegree = rs.getInt("ma_trinh_do");
                int idDivision = rs.getInt("ma_bo_phan");
                employee = new Employee(id, name, birthday, cmnd, salary, phoneNumber, email, address, idPosition, idEducationDegree, idDivision);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnectDB();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME);) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);


            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ma_nhan_vien");
                String name2 = rs.getString("ho_ten");
                Date birthday = rs.getDate("ngay_sinh");
                String cmnd = rs.getString("so_cmnd");
                double salary = rs.getDouble("luong");
                String phoneNumber = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                int idPosition = rs.getInt("ma_vi_tri");
                int idEducationDegree = rs.getInt("ma_trinh_do");
                int idDivision = rs.getInt("ma_bo_phan");
                Employee employee = new Employee(id, name2, birthday, cmnd, salary, phoneNumber, email, address, idPosition, idEducationDegree, idDivision);
                employees.add(employee);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
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
