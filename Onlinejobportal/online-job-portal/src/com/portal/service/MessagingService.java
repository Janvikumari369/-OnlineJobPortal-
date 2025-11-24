package com.portal.service;

import com.portal.common.IdGenerator;
import com.portal.common.PortalException;
import com.portal.dao.MessageDao;
import com.portal.model.Message;

import java.util.List;

public class MessagingService {
    private final MessageDao messageDao = new MessageDao();

    public Message sendMessage(int senderId, int receiverId, Integer jobId, String content) throws PortalException {
        Message m = new Message(IdGenerator.nextMessageId(), senderId, receiverId, jobId, content);
        messageDao.insert(m);
        return m;
    }

    public List<Message> inbox(int userId) throws PortalException {
        return messageDao.inbox(userId);
    }
}