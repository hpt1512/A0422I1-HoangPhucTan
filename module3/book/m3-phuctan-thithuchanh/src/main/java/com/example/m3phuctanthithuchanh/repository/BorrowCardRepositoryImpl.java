package com.example.m3phuctanthithuchanh.repository;

import com.example.m3phuctanthithuchanh.model.Book;
import com.example.m3phuctanthithuchanh.model.BorrowCard;
import com.example.m3phuctanthithuchanh.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowCardRepositoryImpl implements IBaseRepository<BorrowCard> {
    private static final String SELECT_ALL_BORROW_CARD = "SELECT * FROM borrow_card;";
    private static final String SELECT_BORROW_CARD_BY_ID = "select * from borrow_card where id = ?;";
    private static final String UPDATE_STATUS_BORROW_CARD = "update borrow_card set status = 1 where id = ?;";
    private static final String INSERT_BORROW_CARD_SQL = "insert into borrow_card (id_borrow, id_book, id_student, date_start, date_end)\n" +
            "\tvalues (?, ?, ?, ?, ?);";
    @Override
    public List<BorrowCard> findAll() {
        List<BorrowCard> borrowCards = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BORROW_CARD);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String idBorrow = rs.getString("id_borrow");
                int idBook = rs.getInt("id_book");
                int idStudent = rs.getInt("id_student");
                boolean status = rs.getBoolean("status");
                Date date_start = rs.getDate("date_start");
                Date date_end = rs.getDate("date_end");

                borrowCards.add(new BorrowCard(id, idBorrow, idBook, idStudent, status, date_start, date_end));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return borrowCards;
    }

    @Override
    public void insert(BorrowCard borrowCard) throws SQLException {
        System.out.println(INSERT_BORROW_CARD_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BORROW_CARD_SQL)) {
            preparedStatement.setString(1, borrowCard.getIdRorrow());
            preparedStatement.setInt(2, borrowCard.getIdBook());
            preparedStatement.setInt(3, borrowCard.getIdStudent());

            java.sql.Date sqlDateStart = new java.sql.Date(borrowCard.getDate_start().getTime());
            java.sql.Date sqlDateEnd = new java.sql.Date(borrowCard.getDate_end().getTime());

            preparedStatement.setDate(4, sqlDateStart);
            preparedStatement.setDate(5, sqlDateEnd);

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BorrowCard borrowCard) throws SQLException {
        return false;
    }

    public boolean updateStaus(BorrowCard borrowCard) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS_BORROW_CARD);) {
            statement.setInt(1, borrowCard.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public BorrowCard getById(int id) {
        BorrowCard borrowCard = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BORROW_CARD_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                String idBorrow = rs.getString("id_borrow");
                int idBook = rs.getInt("id_book");
                int idStudent = rs.getInt("id_student");
                boolean status = rs.getBoolean("status");
                Date date_start = rs.getDate("date_start");
                Date date_end = rs.getDate("date_end");

                borrowCard = new BorrowCard(id, idBorrow, idBook, idStudent, status, date_start, date_end);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return borrowCard;
    }

    @Override
    public List<BorrowCard> findByName(String name) {
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
