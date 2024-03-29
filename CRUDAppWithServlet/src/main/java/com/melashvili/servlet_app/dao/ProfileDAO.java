package com.melashvili.servlet_app.dao;

import com.melashvili.servlet_app.entity.Profile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO {
    String url = "jdbc:mysql://localhost:3307/ug?autoReconnect=true&useSSL=false";
    String user = "root";
    String password = "123";
    private static final String SELECT_ALL_USERS = "SELECT * FROM some_info";
    private static final String SELECT_USER_BY_ID =
            "SELECT id, first_name, profile_picture FROM some_info WHERE id = ?";
    private static final String INSERT_A_USER =
            "INSERT INTO some_info(first_name, profile_picture) VALUES(?, ?)";
    private static final String DELETE_USER = "DELETE FROM some_info WHERE id = ?";
    private static final String UPDATE_USER =
            "UPDATE some_info SET first_name = ?, profile_picture = ? WHERE id = ?";

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public void insertProfile(Profile profile) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(INSERT_A_USER);
            preparedStatement.setString(1, profile.getFirstName());
            preparedStatement.setBytes(2, profile.getProfilePicture());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public void updateProfile(Profile profile) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, profile.getFirstName());
            preparedStatement.setBytes(2, profile.getProfilePicture());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public List<Profile> getAllProfiles() throws SQLException {
        List<Profile> profiles = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                byte[] profilePicture = resultSet.getBytes("profile_picture");
                Profile profile = new Profile(id, firstName, profilePicture);
                profiles.add(profile);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        return profiles;
    }

    public Profile getProfileById(int userId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Profile profile = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, userId); // Set the userId parameter
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) { // Use if instead of while, assuming userId is unique
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                byte[] profilePicture = resultSet.getBytes("profile_picture");
                profile = new Profile(id, firstName, profilePicture);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return profile;
    }

    public void deleteProfile(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate(); // Execute the delete operation
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}
