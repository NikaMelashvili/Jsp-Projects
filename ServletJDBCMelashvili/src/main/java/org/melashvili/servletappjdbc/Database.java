package org.melashvili.servletappjdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private String url;
    private String user;
    private String pass;
    private String firstName;
    private String lastName;

    public Database(String url, String user, String pass, String firstName, String lastName) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            throw new IllegalStateException("MySQL JDBC Driver not found.", e);
        }
    }

    public Database(String url, String user, String pass){
        this.url = url;
        this.user = user;
        this.pass = pass;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            throw new IllegalStateException("MySQL JDBC Driver not found.", e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public void addStudent() {
        String sql = "INSERT INTO students(first_name, last_name) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.out.println("Couldn't insert student: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Student student = new Student(id, firstName, lastName);
                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Couldn't retrieve students: " + e.getMessage());
        }
        return students;
    }

    public Student getStudentById(Long id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        Student student = null;
        Student updatedStudent = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Long studentId = resultSet.getLong("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    student = new Student(studentId, firstName, lastName);
                    updatedStudent = updateStudent(student);
                }
            }
        } catch (SQLException e) {
            System.out.println("Couldn't retrieve student by id: " + e.getMessage());
        }
        return updatedStudent;
    }

    public Student updateStudent(Student student){
        String sql = "UPDATE students SET first_name = ?, last_name = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(3, student.getId());
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.executeUpdate();
            System.out.println("Student information updated successfully.");
        } catch (SQLException e){
            System.out.println("Failed to update student by id " + student.getId() + ": " + e.getMessage());
        }
        return student;
    }

    public void deleteStudentById(long id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Student with ID " + id + " deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to delete student with ID " + id + ": " + e.getMessage());
        }
    }
}
