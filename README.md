# -OnlineJobPortal-
 The portal will enable employers to post job vacancies, manage applications, and  communicate with candidates. Job seekers can search and apply for jobs, upload their  resumes, and track their application status. Administrators will oversee user management, job  listings, and system settings.

<pre>
online-job-portal/
├─ src/
│  ├─ com/portal/app/
│  │  └─ Main.java
│  ├─ com/portal/common/
│  │  ├─ AppConfig.java
│  │  ├─ DbConnection.java
│  │  ├─ IdGenerator.java
│  │  └─ PortalException.java
│  ├─ com/portal/model/
│  │  ├─ User.java
│  │  ├─ Admin.java
│  │  ├─ Employer.java
│  │  ├─ JobSeeker.java
│  │  ├─ Job.java
│  │  ├─ Application.java
│  │  └─ Message.java
│  ├─ com/portal/dao/
│  │  ├─ UserDao.java
│  │  ├─ JobDao.java
│  │  ├─ ApplicationDao.java
│  │  └─ MessageDao.java
│  ├─ com/portal/service/
│  │  ├─ UserService.java
│  │  ├─ JobService.java
│  │  ├─ ApplicationService.java
│  │  └─ MessagingService.java
│  └─ com/portal/thread/
│     ├─ NotificationWorker.java
│     └─ ActivityMonitor.java
├─ lib/
│  └─ mysql-connector-j-9.0.0.jar
└─ README.md
</pre>
Features
- Admin dashboard: user/job management, settings
- Employer dashboard: job posting, application review, messaging
- Job Seeker dashboard: job search, apply, track status, manage profile
- Real-time notifications & activity monitoring via threads

Technologies
- Java SE
- MySQL + JDBC
- Collections Framework
- Multithreading (Runnable, BlockingQueue, Synchronization)


Author
Team: Recruiters 
Janvi Kumari
Vaishnavi Singh
Manya 
