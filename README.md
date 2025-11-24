# -OnlineJobPortal-
 The portal will enable employers to post job vacancies, manage applications, and  communicate with candidates. Job seekers can search and apply for jobs, upload their  resumes, and track their application status. Administrators will oversee user management, job  listings, and system setting.



##  Project Setup
1. Clone or download the project folder.
2. Ensure you have **Java 17+** installed.
3. Install **MySQL 8+** and create a database named `job_portal`.
4. Run the provided SQL script to create tables (`users`, `jobs`, `applications`, `messages`, `settings`).
5. Download **MySQL Connector/J (mysql-connector-j-9.0.0.jar)** from [MySQL official site](https://dev.mysql.com/downloads/connector/j/) and place it inside the `lib/` folder.
6. Update database credentials in `src/com/portal/common/AppConfig.java`:
   ```java
   public static final String DB_URL = "jdbc:mysql://localhost:3306/job_portal";
   public static final String DB_USER = "root";
   public static final String DB_PASS = "password";

Requirements
- Java SE 17+
- MySQL 8+
- MySQL Connector/J (JDBC driver)
- Any IDE (IntelliJ, Eclipse, VS Code) or command-line tools

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

How to run the project 
Complie
javac -cp lib/mysql-connector-j-9.0.0.jar -d out $(find src -name "*.java")

Run(linux/mac)
java -cp out:lib/mysql-connector-j-9.0.0.jar com.portal.app.Main

Run(Windows)
java -cp out;lib\mysql-connector-j-9.0.0.jar com.portal.app.Main


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
