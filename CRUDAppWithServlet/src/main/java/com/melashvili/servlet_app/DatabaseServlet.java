package com.melashvili.servlet_app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.melashvili.servlet_app.entity.Profile;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "myServlet", value = "/new-servlet")
@MultipartConfig
public class DatabaseServlet extends HttpServlet {

    String url = "jdbc:mysql://localhost:3307/ug?autoReconnect=true&useSSL=false";
    String user = "root";
    String password = "123";

    @Override
    public void init() throws ServletException {
        super.init();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found." + e.getMessage());
            throw new RuntimeException(e);
        }

        String first_name = req.getParameter("first_name");
        Part image = req.getPart("image");
        InputStream inputStream = image.getInputStream();

        String sql = "INSERT INTO some_info(first_name, profile_picture) VALUES (?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, first_name);
            preparedStatement.setBlob(2, inputStream);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        List<Profile> profiles = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM some_info");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                Blob profileImageBlob = resultSet.getBlob("profile_image");
                // Convert Blob to byte array
                byte[] profileImageBytes =
                        profileImageBlob.getBytes(1, (int) profileImageBlob.length());
                Profile profile = new Profile(id, firstName, profileImageBytes);
                profiles.add(profile);
                System.out.println(profile.getFirstName() + " returned to list");
            }
        } catch (SQLException e) {
            throw new ServletException("Error fetching profiles from database", e);
        }

        // Set the someInfoList attribute in the request scope
        req.setAttribute("someInfoList", profiles);
        // Forward the request to the index.jsp page for rendering
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        System.out.println("end of the doGet method.");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
