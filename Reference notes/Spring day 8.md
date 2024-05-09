## Springframework Day 8 - Spring boot part 3 - Spring Boot REST API

 @author Heeren

 ### Topics Covered


---
**What is REST?**  
- REST stands for Representational State Transfer.
- It is used to develop distributed applications.
- It's not a protocol; it's an architectural style used to develop web services.
- It uses HTTP protocol for data communication.
- In RESTful web services, we implement HTTP standard methods.

**Difference Between SOAP and REST?**  
![Capture1](https://github.com/codewithheeren/springframework/assets/87074236/fbfa5295-b127-4a97-8d57-7a2df2a4596b)
![Capture2](https://github.com/codewithheeren/springframework/assets/87074236/304c734f-e370-4af7-ae1c-4dbee2ad7960)
![Capture3](https://github.com/codewithheeren/springframework/assets/87074236/d071e606-9543-46b5-9197-7fc57307c19b)


**Difference Between HTTP and HTTPS?**  
HTTP (Hypertext Transfer Protocol) is unsecured while HTTPS (Hypertext Transfer Protocol Secure) is secured. HTTP sends data over port 80, while HTTPS operates over port 443. HTTP operates at the application layer, while HTTPS operates at the transport layer. SSL certificates are required for HTTPS but not for HTTP.

**What is a Resource?**   
A resource is an object of a type which can be an image, HTML file, text data, or any type of dynamic data. There are various representation formats available to represent a resource, such as XML and JSON.

**Best Practices for Designing RESTful Web Services**   
- Validate every input on the server.
- Ensure input is well-formed.
- Avoid passing sensitive data through URLs.
- Authenticate users for sessions.
- Implement proper exception handling and caching.
- Use HTTP error messages for indicating faults.
- Use a message format that is easily understood by the client.
- Use descriptive and easily understood Unified Resource Identifiers.
- Use caching and pagination for scalability.
- Follow REST API URL naming conventions.

**What is Payload?**   
The request data present in the body part of every HTTP message is referred to as 'Payload'. In RESTful web services, the payload can only be passed to the recipient through the POST method.

**Safe and Unsafe Methods in REST**    
POST, PUT, and DELETE are considered unsafe methods because they make changes on the server. GET is considered safe because it does not make any changes on the server.

**Difference Between POST and PUT**    
POST is used to create a new resource, while PUT is used to update an existing resource. POST is non-idempotent, while PUT is idempotent.

**Why is the HEAD Method Used in REST?**   
The HEAD method is used to retrieve the headers of a resource without transferring the entire representation. It is useful for checking the status of a resource without fetching its full content.

**Why is the PATCH Method Used in REST?**    
The PATCH method is used to apply partial modifications to a resource. It allows clients to update only the specific fields of a resource without having to send the entire representation.

**List of Annotations in RESTful Service**   
- @RestController
- @RequestMapping
- @GetMapping
- @PostMapping
- @DeleteMapping
- @RequestParam
- @PathVariable
- @RequestBody
- @ResponseStatus(HttpStatus.CREATED) or .OK

**Difference Between @RequestMapping and @GetMapping**    
- @RequestMapping is a generic annotation used for mapping HTTP requests to handler methods. It can handle any HTTP method unless specified.
- @GetMapping is a shortcut annotation for @RequestMapping(method = RequestMethod.GET). It is used specifically for handling HTTP GET requests.

**Difference Between @RequestParam and @PathVariable**   
Both @RequestParam and @PathVariable are used to extract values from the request, but they do so from different parts of the URL. @RequestParam extracts values from the query string, while @PathVariable extracts values from the URI path.

**What is the Use of @Path Annotation in RESTful?**   
The @Path annotation is used to identify the URI path. It can be specified at the class or method level to define a common path for all endpoints in the class or for specific endpoints.

**Different Code Responses**   
  - 200: OK (success)
![image](https://github.com/codewithheeren/springframework/assets/87074236/f941c570-bdb1-41e7-be19-b4175e1f9493)

