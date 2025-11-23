package com.portal.dao;

import com.portal.common.DbConnection;
import com.portal.common.PortalException;
import com.portal.model.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDao {
    public void insert(Job job) throws PortalException {
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO jobs(id,employer_id,title,description,requirements,salary,status) VALUES(?,?,?,?,?,?,?)")) {
            ps.setInt(1, job.getId());
            ps.setInt(2, job.getEmployerId());
            ps.setString(3, job.getTitle());
            ps.setString(4, job.getDescription());
            ps.setString(5, job.getRequirements());
            ps.setBigDecimal(6, new java.math.BigDecimal(job.getSalary()));
            ps.setString(7, job.getStatus().name());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PortalException("Job insert failed", e);
        }
    }

    public void updateStatus(int jobId, Job.Status status) throws PortalException {
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE jobs SET status=? WHERE id=?")) {
            ps.setString(1, status.name());
            ps.setInt(2, jobId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PortalException("Job status update failed", e);
        }
    }

    public List<Job> findByStatus(Job.Status status) throws PortalException {
        List<Job> list = new ArrayList<>();
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id,employer_id,title,description,requirements,salary,status FROM jobs WHERE status=?")) {
            ps.setString(1, status.name());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Job j = new Job(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBigDecimal(6).doubleValue());
                    j.setStatus(Job.Status.valueOf(rs.getString(7)));
                    list.add(j);
                }
            }
        } catch (SQLException e) {
            throw new PortalException("Job query by status failed", e);
        }
        return list;
    }

    public List<Job> search(String keyword) throws PortalException {
        List<Job> list = new ArrayList<>();
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id,employer_id,title,description,requirements,salary,status FROM jobs WHERE status='APPROVED' AND (title LIKE ? OR description LIKE ? OR requirements LIKE ?)")) {
            String like = "%" + keyword + "%";
            ps.setString(1, like);
            ps.setString(2, like);
            ps.setString(3, like);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Job j = new Job(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBigDecimal(6).doubleValue());
                    j.setStatus(Job.Status.valueOf(rs.getString(7)));
                    list.add(j);
                }
            }
        } catch (SQLException e) {
            throw new PortalException("Job search failed", e);
        }
        return list;
    }
}