# Online Job Portal (Mini Java Project)

## Overview
A GUI-based Java project that simulates an **Online Job Portal**.  
It demonstrates:
- OOP concepts (Inheritance, Polymorphism, Interfaces, Exception Handling)
- Collections & Generics
- Multithreading & Synchronization
- JDBC database connectivity with DAO classes

Users:
- **Admin**: Manage users, approve/reject jobs, configure settings
- **Employer**: Post jobs, manage applications, communicate with candidates
- **Job Seeker**: Search jobs, apply, track applications, manage profile

---

## Project Structure
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
