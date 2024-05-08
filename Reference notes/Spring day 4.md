## Springframework Day 3 - Spring MVC 

 @author Heeren

 ### Topics Covered
--------------
- Spring MVC Introduction
- Static Web Application
- Dynamic Web Application
- MVC: Model View Controller
- Server
- Port
- Servlet
- JSP Pages
- web.xml
- Spring MVC execution flow
- Steps to develop the SpringMVC application
- WebApplicationContext
- Controller Bean
- Dispatcher Servlet
- Handler mapprings 
- View Resolvers
- Views
- Servlet Context
--------------


#### Static Web Application

#### Dynamic Web Application

#### MVC: Model View Controller

MVC is an architecture pattern where:

- **Model:** DAO classes.

- **View:** JSP pages.

- **Controller:** Linking between backend and frontend.

### Server

A server is a computer program or device that provides a service to another computer program and its user, also known as the client. It is a software which we need to install on a machine and that machine is called a server machine. If we need to deploy any application, we need a server. Examples include Tomcat and GlassFish.

### Port

An application endpoint is called a port. There are 65,000 port numbers in Windows, out of which 1-25,000 are reserved.

### Servlet

A servlet is a Java class which is instantiated by the server and is used to produce dynamic responses. A servlet container is mainly responsible for creating, executing, and instantiating servlets. It manages the servlet and its lifecycle. For example, Tomcat has Catalina as its servlet.

### JSP Pages

JSP (JavaServer Pages) are Java programs that include HTML and CSS pages. They are view pages. We use the `.jsp` extension to write JSP pages to include Java code along with HTML code. A JSP engine is responsible for running JSP pages.

### web.xml

Requests that you want the DispatcherServlet to handle will have to be mapped using a URL mapping in the same `web.xml`.

### WebApplicationContext

Beans whose lifecycle is scoped to the current HTTP request or HTTP Session. This is not a specific feature of Spring MVC itself, but rather of the WebApplicationContext container(s) that Spring MVC uses. It is an extension of a plain application context that has some features necessary for web application. In the web MVC framework, DispatcherServlet has its own WebApplicationContext.

### Controller Bean

Spring Controller annotation can be applied on classes only. It's used to mark a class as a web request handler. It's mostly used with Spring MVC application.

### Client Browser -> HTTP Request -> Server -> Servlet -> Response Sent to Server -> HTTP Response -> Client Browser

There are two types of architecture:

1\. Model 2 types of applications

2\. MVC type of applications

### MVC Flow

#### Dispatcher Servlet

- Is the king of all servlets.

- Main servlet.

- Front controller/front servlet.

#### URL Handler

Helper class to find appropriate controller class.

#### Controller Bean

#### View Resolver

Gives logical view name.

#### Views

Dispatcher servlet:

- Is a front controller servlet.

- Every request comes to the dispatcher servlet, then the dispatcher servlet is responsible to handle the flow of the whole request/process.

#### Servlet Context

Created by a web container at the time of deployment of the application.