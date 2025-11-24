package com.portal.service;

import com.portal.common.IdGenerator;
import com.portal.common.PortalException;
import com.portal.dao.JobDao;
import com.portal.model.Job;

import java.util.List;

public class JobService {
    private final JobDao jobDao = new JobDao();

    public Job postJob(int employerId, String title, String description, String requirements, double salary) throws PortalException {
        Job j = new Job(IdGenerator.nextJobId(), employerId, title, description, requirements, salary);
        jobDao.insert(j);
        return j;
    }

    public void approveJob(int jobId) throws PortalException {
        jobDao.updateStatus(jobId, Job.Status.APPROVED);
    }

    public void rejectJob(int jobId) throws PortalException {
        jobDao.updateStatus(jobId, Job.Status.REJECTED);
    }

    public List<Job> pendingJobs() throws PortalException {
        return jobDao.findByStatus(Job.Status.PENDING);
    }

    public List<Job> approvedJobs() throws PortalException {
        return jobDao.findByStatus(Job.Status.APPROVED);
    }

    public List<Job> search(String keyword) throws PortalException {
        return jobDao.search(keyword);
    }
}