package com.portal.dao;

import com.portal.common.DbConnection;
import com.portal.common.PortalException;
import com.portal.model.User;
import com.portal.model.Admin;
import com.portal.model.Employer;
import com.portal.model.JobSeeker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public void insert(User user) throws PortalException {
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO users(id,name,email,role,resume) VALUES(?,?,?,?,?)")) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getRole().name());
            ps.setString(5, (user instanceof JobSeeker) ? ((JobSeeker) user).getResume() : null);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PortalException("User insert failed", e);
        }
    }

    public void updateResume(int seekerId, String resume) throws PortalException {
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE users SET resume=? WHERE id=? AND role='JOB_SEEKER'")) {
            ps.setString(1, resume);
            ps.setInt(2, seekerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PortalException("Resume update failed", e);
        }
    }

    public List<User> findAll() throws PortalException {
        List<User> list = new ArrayList<>();
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id,name,email,role,resume FROM users");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String role = rs.getString(4);
                String resume = rs.getString(5);
                switch (User.Role.valueOf(role)) {
                    case ADMIN: list.add(new Admin(id, name, email)); break;
                    case EMPLOYER: list.add(new Employer(id, name, email)); break;
                    case JOB_SEEKER: list.add(new JobSeeker(id, name, email, resume)); break;
                }
            }
        } catch (SQLException e) {
            throw new PortalException("User query failed", e);
        }
        return list;
    }

    public void delete(int userId) throws PortalException {
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id=?")) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PortalException("User deletion failed", e);
        }
    }
}