package com.portal.service;

import com.portal.common.IdGenerator;
import com.portal.common.PortalException;
import com.portal.dao.ApplicationDao;
import com.portal.model.Application;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ApplicationService {
    private final ApplicationDao applicationDao = new ApplicationDao();

    private final Map<Integer, List<Application>> appCacheByJob = Collections.synchronizedMap(new HashMap<>());
    private final BlockingQueue<Application> appEvents = new LinkedBlockingQueue<>();

    public Application apply(int jobId, int seekerId, String coverLetter) throws PortalException {
        Application app = new Application(IdGenerator.nextApplicationId(), jobId, seekerId, coverLetter);
        applicationDao.insert(app);
        synchronized (appCacheByJob) {
            appCacheByJob.computeIfAbsent(jobId, k -> Collections.synchronizedList(new ArrayList<>())).add(app);
        }
        appEvents.offer(app);
        return app;
    }

    public List<Application> getApplicationsForJob(int jobId) throws PortalException {
        List<Application> cached;
        synchronized (appCacheByJob) {
            cached = appCacheByJob.get(jobId);
        }
        if (cached != null) return new ArrayList<>(cached);
        List<Application> list = applicationDao.findByJob(jobId);
        synchronized (appCacheByJob) {
            appCacheByJob.put(jobId, Collections.synchronizedList(new ArrayList<>(list)));
        }
        return list;
    }

    public void updateStatus(int appId, Application.Status status) throws PortalException {
        applicationDao.updateStatus(appId, status);
    }

    public BlockingQueue<Application> getApplicationEvents() {
        return appEvents;
    }
}