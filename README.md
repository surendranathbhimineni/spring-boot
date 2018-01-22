# spring-boot


This is a Java / Maven / Spring Boot (version 1.5.6) application that can be used as a starter for creating a microservice complete with built-in health check, metrics and much more.

How to install java:
	https://docs.oracle.com/javase/8/docs/technotes/guides/install/windows_jdk_install.html

How to install Maven:
	https://www.mkyong.com/maven/how-to-install-maven-in-windows/

How to install git:
	https://www.atlassian.com/git/tutorials/install-git#windows

Clone repo into your workspace:
	git clone https://github.com/surendranathbhimineni/spring-boot.git
	
## How to Run 

This application is packaged as a jar which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```mvn spring-boot:run```
or
 ```java -jar target/csra-radv-aws-app-0.0.1-SNAPSHOT.jar```

Once the application runs you should see something like this
```
2017-10-08 19:52:10.121  INFO 18660 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8000 (http)
2017-10-08 19:52:10.125  INFO 18660 --- [           main] com.csra.radv.Application                : Started Application in 3.75 seconds (JVM running for 4.271)
```
### To view Swagger 2 API docs

Run the server and browse to localhost:8080/swagger-ui.html

### To view H2-CONSOLE

You can look at http://localhost:8080/application/flyway to review the list of scripts.

This sample also enables the H2 console (at http://localhost:8080/h2-console) so that you can review the state of the database (the default jdbc url is jdbc:h2:mem:testdb).

## About the Service

Testing Rest endpoints:

Swagger:
http://localhost:8080/swagger-ui.html


