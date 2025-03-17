## Microservices Day 1
@author Heeren

 **Topics Covered**
--------------
**will come from topics need to cover**

1. [Java Features and Compilation, Execution Architecture of Java Program](#1-java-features-and-compilation-execution-architecture-of-java-program)       
2. [Types of Class Loaders](#2-types-of-class-loaders)       
.
.
8. [Assignment](#8-assignment)
--------------
🔵 **Monolithic Application Architecture**     

- Monolithic application holds all modules together and converted as one Service (one .war file).    
- In Monolothic application all components (frontend, backend)are tightly integrated.    
- This approach works well for small to medium-scale applications.    
    
🔵 **Microservice Application Architecture**    
- Microservices is an architecture style where we develop application having multiple services.    
- Each service is independent or loosely coupled, cloud enabled and deployable.    
- Those services interact with each other and exposed by REST.
- The most important feature of the microservice-based architecture is that it can perform continuous delivery of a large and complex application.

![image](https://github.com/user-attachments/assets/58f1277e-50dc-4ae7-92db-d0182b0474c9)

In the above figure, each microservice has its own business layer and database. If we change in one microservice, it does not affect the other services.    
- These services communicate with each other by using lightweight protocols such as HTTP or REST or messaging protocols.   

