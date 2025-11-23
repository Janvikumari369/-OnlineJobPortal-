# -OnlineJobPortal-
 The portal will enable employers to post job vacancies, manage applications, and  communicate with candidates. Job seekers can search and apply for jobs, upload their  resumes, and track their application status. Administrators will oversee user management, job  listings, and system settings.
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>Project Structure</title>
  <style>
    body { font-family: Menlo, Monaco, "Courier New", monospace; padding: 20px; }
    pre.tree { background:#f7f7f7; border:1px solid #e0e0e0; padding:12px; border-radius:6px; white-space: pre; }
  </style>
</head>
<body>
  <h1>Project Structure</h1>
  <pre class="tree">
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
</body>
</html>
