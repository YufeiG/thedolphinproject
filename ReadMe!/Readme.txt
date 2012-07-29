Software Requirements:
1. Eclipse Enterprise Edition
2. Apache Tomcat 6.0
3. MySQL Database and/or MySQL Workbench
4. MySQL JDBC (MySQL Connector J)
5. Apache Commons


Setup
1. Download all required softwares
2. Install MySQL Database on local machine (note: save password)
3. Run the database script(DBSchema.txt) to setup the database
4. Create a Dynamic Web Project in Eclipse using the source files
5. Configure the classpath of the project and add the Connector J and Apache Commons jar 
6. Create a Tomcat Server and link the project to the server
7. Open the file MarketplaceConfig located in the global package and change the DB_PW variable to the password for the MySQL Database
8. Run the project on the Tomcat Server


Implemented functionalities
1. Create Account
2. Sign in, sign out
3. Search items by keyword and by category (the Books, Housing, etc. dropdown in the header)
4. Add/Edit/Delete Items
5. Add/Delete for Watch List
6. Add/Delete for Wish List
7. View/Edit user profile
8. Wish List matching, email matched items to user
9. View all user created items




Incomplete implementations
1. Generate recommendations
2. Export Lists
3. Additional search and wish list matching algorithms
4. Account Verification
5. Redo error handling; current error handling is sending the string “error” as result. HttpResponse can be assigned an error so more information can be returned. Then specialized error pages can be shown (eg. server down page)