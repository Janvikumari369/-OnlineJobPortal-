package com.portal.dao;

import com.portal.common.DbConnection;
import com.portal.common.PortalException;
import com.portal.model.Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDao {
    public void insert(Application app) throws PortalException {
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO applications(id,job_id,seeker_id,cover_letter,status) VALUES(?,?,?,?,?)")) {
            ps.setInt(1, app.getId());
            ps.setInt(2, app.getJobId());
            ps.setInt(3, app.getSeekerId());
            ps.setString(4, app.getCoverLetter());
            ps.setString(5, app.getStatus().name());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PortalException("Application insert failed", e);
        }
    }

    public void updateStatus(int appId, Application.Status status) throws PortalException {
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE applications SET status=? WHERE id=?")) {
            ps.setString(1, status.name());
            ps.setInt(2, appId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PortalException("Application status update failed", e);
        }
    }

    public List<Application> findByJob(int jobId) throws PortalException {
        List<Application> list = new ArrayList<>();
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id,job_id,seeker_id,cover_letter,status FROM applications WHERE job_id=?")) {
            ps.setInt(1, jobId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
                    a.setStatus(Application.Status.valueOf(rs.getString(5)));
                    list.add(a);
                }
            }
        } catch (SQLException e) {
            throw new PortalException("Application query by job failed", e);
        }
        return list;
    }

    public List<Application> findBySeeker(int seekerId) throws PortalException {
        List<Application> list = new ArrayList<>();
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id,job_id,seeker_id,cover_letter,status FROM applications WHERE seeker_id=?")) {
            ps.setInt(1, seekerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Application a = new Application(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
                    a.setStatus(Application.Status.valueOf(rs.getString(5)));
                    list.add(a);
                }
            }
        } catch (SQLException e) {
            throw new PortalException("Application query by seeker failed", e);
        }
        return list;
    }
}