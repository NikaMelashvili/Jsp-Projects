package com.melashvili.servlet_app;

import com.melashvili.servlet_app.dao.ProfileDAO;
import com.melashvili.servlet_app.entity.Profile;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "myServlet", value = "/new-servlet")
@MultipartConfig
public class ProfileServlet extends HttpServlet {

    private ProfileDAO profileDAO;

    public ProfileServlet(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action){
            case "/new":
                showNewForm(req, resp);
                break;
            case "/insert":
                try {
                    addProfile(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/delete":
                try {
                    deleteProfile(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/edit":
                try {
                    editProfile(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/update":
                try {
                    updateProfile(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    listProfiles(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
    private void showNewForm(HttpServletRequest request,
                             HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addRow.jsp");
        dispatcher.forward(request, response);
    }

    private void addProfile(HttpServletRequest request,
                            HttpServletResponse response)
            throws IOException, SQLException {
        String name = request.getParameter("first_name");
        byte[] profilePicture = request.getInputStream().readAllBytes();
        Profile profile = new Profile(name, profilePicture);
        profileDAO.insertProfile(profile);
        response.sendRedirect("index.jsp");
    }

    private void deleteProfile(HttpServletRequest request,
                               HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        profileDAO.deleteProfile(id);
        response.sendRedirect("index.jsp");
    }

    private void editProfile(HttpServletRequest request,
                               HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Profile profile = profileDAO.getProfileById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("profile", profile);
        dispatcher.forward(request, response);
    }

    private void updateProfile(HttpServletRequest request,
                               HttpServletResponse response)
            throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("first_name");
        byte[] profilePicture = request.getInputStream().readAllBytes();

        Profile profile = new Profile(id, firstName, profilePicture);
        profileDAO.updateProfile(profile);
        response.sendRedirect("index.jsp");
    }

    private void listProfiles(HttpServletRequest request,
                              HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Profile> profiles = profileDAO.getAllProfiles();
        request.setAttribute("profiles", profiles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
