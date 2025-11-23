package com.portal.service;

import com.portal.common.IdGenerator;
import com.portal.common.PortalException;
import com.portal.dao.UserDao;
import com.portal.model.*;

import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();

    public Admin createAdmin(String name, String email) throws PortalException {
        Admin a = new Admin(IdGenerator.nextUserId(), name, email);
        userDao.insert(a);
        return a;
    }

    public Employer createEmployer(String name, String email) throws PortalException {
        Employer e = new Employer(IdGenerator.nextUserId(), name, email);
        userDao.insert(e);
        return e;
    }

    public JobSeeker createJobSeeker(String name, String email, String resume) throws PortalException {
        JobSeeker js = new JobSeeker(IdGenerator.nextUserId(), name, email, resume);
        userDao.insert(js);
        return js;
    }

    public void updateResume(int seekerId, String resume) throws PortalException {
        userDao.updateResume(seekerId, resume);
    }

    public List<User> allUsers() throws PortalException {
        return userDao.findAll();
    }

    public void deleteUser(int userId) throws PortalException {
        userDao.delete(userId);
    }
}