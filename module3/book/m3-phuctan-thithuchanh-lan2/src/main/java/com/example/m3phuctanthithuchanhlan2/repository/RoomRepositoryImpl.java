package com.example.m3phuctanthithuchanhlan2.repository;

import com.example.m3phuctanthithuchanhlan2.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements IBaseRepository<Room>{
    private static final String SELECT_ALL_ROOM = "SELECT * FROM room;";
    private static final String INSERT_ROOM_SQL = "insert into room (username, phone_number, date_start, id_pay, note)\n" +
            "values (?, ?, ?, ?, ?);";
    private static final String DELETE_ROOM_SQL = "delete from room where id = ?;";
    private static final String SELECT_ROOM_BY_ID = "select * from room where id = ?;";
    private static final String FIND_ROOM_BY_USERNAME = "select * from room where id like concat('%', ?, '%') and username like concat('%', ?, '%') \n" +
            "and phone_number like concat('%', ?, '%');";

    @Override
    public List<Room> findAll() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOM);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String phoneNumber = rs.getString("phone_number");
                Date dateStart = rs.getDate("date_start");
                int idPay = rs.getInt("id_pay");
                String note = rs.getString("note");

                rooms.add(new Room(id, username, phoneNumber, dateStart, idPay, note));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rooms;
    }

    @Override
    public void insert(Room room) throws SQLException {
        System.out.println(INSERT_ROOM_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_SQL)) {
            preparedStatement.setString(1, room.getUsername());
            preparedStatement.setString(2, room.getPhoneNumber());

            java.sql.Date sqlDateStart = new java.sql.Date(room.getDateStart().getTime());

            preparedStatement.setDate(3, sqlDateStart);
            preparedStatement.setInt(4, room.getIdPay());
            preparedStatement.setString(5, room.getNote());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_ROOM_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Room room) throws SQLException {
        return false;
    }

    @Override
    public Room getById(int id) {
        Room room = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROOM_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                String username = rs.getString("username");
                String phoneNumber = rs.getString("phone_number");
                Date dateStart = rs.getDate("date_start");
                int idPay = rs.getInt("id_pay");
                String note = rs.getString("note");

                room = new Room(id, username, phoneNumber, dateStart, idPay, note);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return room;
    }

    @Override
    public List<Room> findByName(String idFind, String nameFind, String phoneNumberFind) {
        List<Room> rooms = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnectDB();

             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ROOM_BY_USERNAME);) {
            preparedStatement.setString(1, idFind);
            preparedStatement.setString(2, nameFind);
            preparedStatement.setString(3, phoneNumberFind);
            System.out.println(preparedStatement);


            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String phoneNumber = rs.getString("phone_number");
                Date dateStart = rs.getDate("date_start");
                int idPay = rs.getInt("id_pay");
                String note = rs.getString("note");

                Room room = new Room(id, username, phoneNumber, dateStart, idPay, note);
                rooms.add(room);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return rooms;
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
