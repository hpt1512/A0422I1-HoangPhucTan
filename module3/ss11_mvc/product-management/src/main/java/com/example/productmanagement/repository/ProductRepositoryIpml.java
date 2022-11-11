package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryIpml implements ProductRepository {
    //    private static Map<Integer, Product> products = new HashMap<>();
    private final String SELECT_ALL = "select * from products;";
    private final String INSERT_PRODUCT = "insert into products (`name`, price, `description`, producer)" + "values (?, ?, ?, ?);";
    private final String FIND_BY_ID = "select id, `name`, price, `description`, producer from products where id = ?;";
    private static final String DELETE_PRODUCT = "delete from products where id = ?;";


    @Override
    public List<Product> findAll() {
        // kết nối db để láy dữ liệu
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement pr = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = pr.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");// columnLable : tên trường trong database// get theo kiểu dữ liệu của Java
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                String producer = resultSet.getString("producer");


                Product product = new Product(id, name, price, description, producer);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        System.out.println(INSERT_PRODUCT);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getProducer());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnectDB();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String description = rs.getString("description");
                String producer = rs.getString("producer");
                product = new Product(id, name, price, description, producer);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    @Override
    public void update(int id, Product product) {
//        products.put(id, product);
    }

    @Override
    public boolean remove(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


//    @Override
//    public List<Product> findByName(String name) {
//        List<Product> productList = this.findAll();
//        List<Product> resultFind = new ArrayList<>();
//        for (Product product : productList) {
//            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
//                resultFind.add(product);
//            }
//        }
//        return resultFind;
//    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        String query = "{call find_product_by_name(?)};";
        // try-with-resource statement will auto close the connection.

        try (Connection connection = BaseRepository.getConnectDB();

             CallableStatement callableStatement = connection.prepareCall(query);) {
            System.out.println(callableStatement);
            callableStatement.setString(1, name);

            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name2 = rs.getString("name");
                int price = rs.getInt("price");
                String description = rs.getString("description");
                String producer = rs.getString("producer");
                products.add(new Product(id, name2, price, description, producer));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
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
