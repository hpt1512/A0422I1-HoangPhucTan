package com.example.furamamanagement.repository.division;

import com.example.furamamanagement.model.Division;
import com.example.furamamanagement.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements IDivisionRepository {
    private static final String SELECT_ALL_DIVISIONS = "SELECT * FROM bo_phan;";
    @Override
    public List<Division> selectAllDivisions() {
        List<Division> divisions = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISIONS);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("ma_bo_phan");
                String name = rs.getString("ten_bo_phan");

                divisions.add(new Division(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return divisions;
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
