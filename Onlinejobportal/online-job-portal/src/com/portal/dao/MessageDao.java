package com.portal.dao;

import com.portal.common.DbConnection;
import com.portal.common.PortalException;
import com.portal.model.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    public void insert(Message m) throws PortalException {
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO messages(id,sender_id,receiver_id,job_id,content) VALUES(?,?,?,?,?)")) {
            ps.setInt(1, m.getId());
            ps.setInt(2, m.getSenderId());
            ps.setInt(3, m.getReceiverId());
            if (m.getJobId() == null) ps.setNull(4, Types.INTEGER); else ps.setInt(4, m.getJobId());
            ps.setString(5, m.getContent());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PortalException("Message insert failed", e);
        }
    }

    public List<Message> inbox(int userId) throws PortalException {
        List<Message> list = new ArrayList<>();
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id,sender_id,receiver_id,job_id,content FROM messages WHERE receiver_id=? ORDER BY created_at DESC")) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Integer jobId = rs.getObject(4) == null ? null : rs.getInt(4);
                    list.add(new Message(rs.getInt(1), rs.getInt(2), rs.getInt(3), jobId, rs.getString(5)));
                }
            }
        } catch (SQLException e) {
            throw new PortalException("Inbox query failed", e);
        }
        return list;
    }
}