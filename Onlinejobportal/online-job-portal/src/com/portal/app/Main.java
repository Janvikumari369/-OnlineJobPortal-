package com.portal.app;

import com.portal.common.PortalException;
import com.portal.model.*;
import com.portal.service.*;
import com.portal.thread.ActivityMonitor;
import com.portal.thread.NotificationWorker;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        JobService jobService = new JobService();
        ApplicationService applicationService = new ApplicationService();
        MessagingService messagingService = new MessagingService();

        Thread notifyThread = new Thread(new NotificationWorker(applicationService.getApplicationEvents()), "NotifyWorker");
        ActivityMonitor monitor = new ActivityMonitor();
        Thread monitorThread = new Thread(monitor, "ActivityMonitor");

        notifyThread.start();
        monitorThread.start();

        try {
            Admin admin = userService.createAdmin("Rashmi(Admin)", "admin@portal.com");
            Employer emp = userService.createEmployer("Acme Corp", "hr@acme.com");
            JobSeeker js = userService.createJobSeeker("Rashmi", "rashmi@example.com", "Experienced in Java, DSA");

            Job job = jobService.postJob(emp.getId(), "Java Developer",
                    "Build backend services", "Java, Spring, SQL", 1200000.00);

            List<Job> pending = jobService.pendingJobs();
            System.out.println(admin.dashboardTitle() + " - Pending Jobs: " + pending);
            jobService.approveJob(job.getId());

            List<Job> approved = jobService.approvedJobs();
            System.out.println(admin.dashboardTitle() + " - Approved Jobs: " + approved);

            List<Job> search = jobService.search("Java");
            System.out.println(js.dashboardTitle() + " - Search Results: " + search);

            Application app = applicationService.apply(job.getId(), js.getId(), "I love building reliable services.");
            System.out.println("Applied: " + app);

            applicationService.updateStatus(app.getId(), Application.Status.REVIEWING);
            System.out.println("Application status updated to REVIEWING");

            Message m = messagingService.sendMessage(emp.getId(), js.getId(), job.getId(),
                    "Thanks for applying! Please share availability for interview.");
            System.out.println("Message sent: " + m);

            System.out.println("Inbox for Job Seeker:");
            messagingService.inbox(js.getId()).forEach(System.out::println);

            System.out.println(admin.dashboardTitle() + " - All Users:");
            userService.allUsers().forEach(System.out::println);

        } catch (PortalException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            monitorThread.interrupt();
            notifyThread.interrupt();
        }
    }
}