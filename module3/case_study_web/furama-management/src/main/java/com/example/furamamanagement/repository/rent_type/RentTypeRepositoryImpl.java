package com.example.furamamanagement.repository.rent_type;

import com.example.furamamanagement.model.RentType;
import com.example.furamamanagement.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements IRenTypeRepository {
    private static final String SELECT_ALL_RENT_TYPES = "SELECT * FROM kieu_thue;";
    @Override
    public List<RentType> selectAllRentTypes() {
        List<RentType> rentTypes = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_TYPES);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("ma_kieu_thue");
                String name = rs.getString("ten_kieu_thue");

                rentTypes.add(new RentType(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rentTypes;
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
