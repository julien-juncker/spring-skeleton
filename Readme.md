# Spring skeleton

## Where is the documentation ?
How to read the doc : [link](/docapi/Readme.md)

## TODO list
- Add more constraints (annotation or interface) for Aggregate. 

## D.D.D Domain composition
### Entity
Object in the domain that is defined by its identity, rather than its attributes.

### Value-object
Representing elements defined solely by their attributes.  
He doesn't have an identity, but describe a part of the domain.  
Useful to reduce cost (avoid to create object as entity).  

Architecture constraints : 
- If value object are shareable, he needs to be immutable.

### Service
Orchestrates interactions between different objects in the domain.  

Architecture constraints :
- Need to be called by the application layer.
- Use port to communicate with repositories (persistence).
- Ensure that all database operations within the method are atomic (transactional annotation).

### Aggregates
Cluster of Domain Objects (Entities and Value Objects) that are bound together by a root Entity, known as the Aggregate Root.  

Architecture constraints : 
- Aggregate must contain only 1 root entity.
- Root need to be an entity class.
- Root and object can reference each other.
- External object can only reference root entity from her aggregate and other.
- Other entity need be internal of aggregate.
- If aggregates are stored in DB, only the root entity can be obtained by request.

### Factory
**Useful only for complex aggregate.**  
Encapsulate necessary knowledge for creating an object (useful for creating aggregate).  

Architecture constraints :
- Create all object and apply all invariants when a root object is created.
- The 'product' is an interface, and need to be implemented by all concrete product.

Not use factory method when :
- Construction is easier
- Object creation don't need to create other objects, and all needed properties are passed on constructor. 
- Client want to choose strategy to use and are interested in implementation.

### D.D.D principles
- Always use ubiquitous language for functional and technical side.
- Continuous refactoring.
- Make the code explicit : 
  - **Constraints**: Explain invariants easily. (Isolate and give a clear name to a condition).
  - **Process**: Procedure (Best way is on the service).
  - **Specifications**: Test an object to see if it meets certain criteria. Need to be created on specific class.