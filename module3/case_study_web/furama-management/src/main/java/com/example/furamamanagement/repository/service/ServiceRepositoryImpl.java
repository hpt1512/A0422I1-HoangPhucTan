package com.example.furamamanagement.repository.service;

import com.example.furamamanagement.model.Service;
import com.example.furamamanagement.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements IServiceRepository {
    private static final String SELECT_ALL_SERVICES = "SELECT * FROM dich_vu;";
    private static final String INSERT_SERVICE_SQL = "insert into dich_vu (ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue, ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang)\n" +
            "\tvalues \t(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_SERVICE_SQL = "delete from dich_vu where ma_dich_vu = ?;";
    private static final String UPDATE_SERVICE_SQL = "update dich_vu set ten_dich_vu = ?, dien_tich = ?, chi_phi_thue = ?, so_nguoi_toi_da = ?, ma_kieu_thue = ?, \n" +
            "\tma_loai_dich_vu = ?, tieu_chuan_phong = ? , mo_ta_tien_nghi_khac = ?, dien_tich_ho_boi = ?, so_tang = ?\n" +
            "where ma_dich_vu = ?;";
    private static final String SELECT_SERVICE_BY_ID = "select * from dich_vu where ma_dich_vu = ?;";
    private static final String SELECT_SERVICE_BY_NAME_RENT_SERVICE = "select * from dich_vu where ten_dich_vu like concat('%', ?, '%') and ma_kieu_thue like concat('%', ?, '%') \n" +
            "and ma_loai_dich_vu like concat('%', ?, '%');";

    @Override
    public List<Service> selectAllServices() {
        List<Service> services = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICES);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("ma_dich_vu");
                String name = rs.getString("ten_dich_vu");
                int area = rs.getInt("dien_tich");
                double rent_cost = rs.getDouble("chi_phi_thue");
                int peopleMax = rs.getInt("so_nguoi_toi_da");
                int idRentType = rs.getInt("ma_kieu_thue");
                int idServiceType = rs.getInt("ma_loai_dich_vu");
                String standardRoom = rs.getString("tieu_chuan_phong");
                String descriptionOtherConvenience = rs.getString("mo_ta_tien_nghi_khac");
                double poolArea = rs.getDouble("dien_tich_ho_boi");
                int floor = rs.getInt("so_tang");

                services.add(new Service(id, name, area, rent_cost, peopleMax, idRentType, idServiceType, standardRoom, descriptionOtherConvenience, poolArea, floor));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return services;
    }


    @Override
    public void insertService(Service service) throws SQLException {
        System.out.println(INSERT_SERVICE_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL)) {
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setDouble(3, service.getRent_cost());
            preparedStatement.setInt(4, service.getPeopleMax());
            preparedStatement.setInt(5, service.getIdRentType());
            preparedStatement.setInt(6, service.getIdServiceType());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getFloor());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_SERVICE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE_SQL);) {
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setDouble(3, service.getRent_cost());
            preparedStatement.setInt(4, service.getPeopleMax());
            preparedStatement.setInt(5, service.getIdRentType());
            preparedStatement.setInt(6, service.getIdServiceType());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getFloor());
            preparedStatement.setInt(11, service.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Service getServiceById(int id) {
        Service service = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("ten_dich_vu");
                int area = rs.getInt("dien_tich");
                double rent_cost = rs.getDouble("chi_phi_thue");
                int peopleMax = rs.getInt("so_nguoi_toi_da");
                int idRentType = rs.getInt("ma_kieu_thue");
                int idServiceType = rs.getInt("ma_loai_dich_vu");
                String standardRoom = rs.getString("tieu_chuan_phong");
                String descriptionOtherConvenience = rs.getString("mo_ta_tien_nghi_khac");
                double poolArea = rs.getDouble("dien_tich_ho_boi");
                int floor = rs.getInt("so_tang");

                service = new Service(id, name, area, rent_cost, peopleMax, idRentType, idServiceType, standardRoom, descriptionOtherConvenience, poolArea, floor);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return service;
    }

    @Override
    public List<Service> findByNameRentService(String nameFind, String rentTypeFind, String serviceTypeFind) {
        List<Service> services = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnectDB();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_NAME_RENT_SERVICE);) {
            preparedStatement.setString(1, nameFind);
            preparedStatement.setString(2, rentTypeFind);
            preparedStatement.setString(3, serviceTypeFind);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ma_dich_vu");
                String name = rs.getString("ten_dich_vu");
                int area = rs.getInt("dien_tich");
                double rent_cost = rs.getDouble("chi_phi_thue");
                int peopleMax = rs.getInt("so_nguoi_toi_da");
                int idRentType = rs.getInt("ma_kieu_thue");
                int idServiceType = rs.getInt("ma_loai_dich_vu");
                String standardRoom = rs.getString("tieu_chuan_phong");
                String descriptionOtherConvenience = rs.getString("mo_ta_tien_nghi_khac");
                double poolArea = rs.getDouble("dien_tich_ho_boi");
                int floor = rs.getInt("so_tang");

                Service service = new Service(id, name, area, rent_cost, peopleMax, idRentType, idServiceType, standardRoom, descriptionOtherConvenience, poolArea, floor);
                services.add(service);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return services;
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
