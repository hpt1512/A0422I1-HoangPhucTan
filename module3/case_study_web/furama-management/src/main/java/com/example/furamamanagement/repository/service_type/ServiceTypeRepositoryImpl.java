package com.example.furamamanagement.repository.service_type;

import com.example.furamamanagement.model.ServiceType;
import com.example.furamamanagement.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements IServiceTypeRepository {
    private static final String SELECT_ALL_SERVICE_TYPES = "SELECT * FROM loai_dich_vu;";
    @Override
    public List<ServiceType> selectAllServiceTypes() {
        List<ServiceType> serviceTypes = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPES);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("ma_loai_dich_vu");
                String name = rs.getString("ten_loai_dich_vu");

                serviceTypes.add(new ServiceType(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return serviceTypes;
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
