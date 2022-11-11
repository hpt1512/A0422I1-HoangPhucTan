package com.example.furamamanagement.repository.education_degree;

import com.example.furamamanagement.model.EducationDegree;
import com.example.furamamanagement.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements IEducationDegreeRepository {
    private static final String SELECT_ALL_EDUCATION_DEGREES = "SELECT * FROM trinh_do;";
    @Override
    public List<EducationDegree> selectAllEducationDegrees() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREES);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("ma_trinh_do");
                String name = rs.getString("ten_trinh_do");

                educationDegrees.add(new EducationDegree(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return educationDegrees;
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
