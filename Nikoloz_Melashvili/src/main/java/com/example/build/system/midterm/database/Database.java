package com.example.build.system.midterm.database;

import com.example.build.system.midterm.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
     public Connection getConnection() throws SQLException {
         String url = "jdbc:mysql://localhost:3307/nikamelashvili";
         String user = "root";
         String password = "123";
         return DriverManager.getConnection(url, user, password);
     }

     public void createProduct(Product product){
         String name = product.getName();
         double price = product.getPrice();
         int quantity = product.getQuantity();

         String sql = "INSERT INTO products(name, price, quantity) " +
                 "VALUES (?, ?, ?)";

         Connection connection = null;
         PreparedStatement preparedStatement = null;
         try {
             connection = getConnection();
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.executeUpdate();
             System.out.println("Object By id " + product.getId() + " saved in db");
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }

     public List<Product> getAllProducts() throws SQLException {
         String sql = "SELECT * FROM products";

         Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         ResultSet resultSet = preparedStatement.executeQuery();
         List<Product> products = new ArrayList<>();

         while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            int quantity = resultSet.getInt("quantity");
            Product product = new Product(id, name, price, quantity);
            products.add(product);
         }
         return products;
     }
}
