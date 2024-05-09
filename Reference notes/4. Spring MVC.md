## Springframework Day 4 - Spring MVC 

 @author Heeren

 ### Topics Covered
--------------
- Spring MVC Introduction
- Static Web Application
- Dynamic Web Application
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
![Capture1](https://github.com/codewithheeren/springframework/assets/87074236/400a30a2-85b8-420c-80d7-6df4cbf10291)

#### Dynamic Web Application   
![Capture2](https://github.com/codewithheeren/springframework/assets/87074236/5b25f27c-dc6e-499b-8f9b-d8a1d16167b2)


#### MVC: Model View Controller Execution Flow

MVC is an architecture pattern where:

- **Model:** DAO classes.

- **View:** JSP pages.

- **Controller:** Linking between backend and frontend.
![Capture3](https://github.com/codewithheeren/springframework/assets/87074236/19ee1504-1433-42f6-9970-9c98a8cbd53f)

### Client Browser -> HTTP Request -> Server -> Servlet -> Response Sent back to end user -> HTTP Response -> Client Browser

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

### Controller Bean

Spring Controller annotation can be applied on classes only. It's used to mark a class as a web request handler. It's mostly used with Spring MVC application.

#### Dispatcher Servlet

- Is the king of all servlets.
- Main servlet.
- Front controller/front servlet.
- Every request comes to the dispatcher servlet, then the dispatcher servlet is responsible to handle the flow of the whole request/process.

#### Handler Mapping Class
Helper class to find appropriate controller class.

#### Controller Bean
Conssit of various request handler method , which are responsible to handle different http requests.

#### View Resolver
Map Dispatcher servlet to appropriate logical view file path.

#### Views
Responsible to represent presentation layer of mvc application.

#### Servlet Context
Created by a web container at the time of deployment of the application.
