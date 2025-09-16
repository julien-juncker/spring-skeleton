+++
title = "Architecture"
date = "2025-04-28"
author = "julien-juncker"
+++

### Apps Module

The `apps` module contains controllers, which are the entry points for the API. 
Data Transfer Objects (DTOs) are automatically generated using an OpenAPI generator library, adhering to a contract-first approach. 
These DTOs are mapped to domain objects using mappers, specifically MapStruct. 
This module also includes the main application class that launches the Spring application, along with all the necessary Spring configuration.

---

### Domain Module

The `domain` layer is the core of the application, containing all business logic and rules. It is technology-agnostic and organized around key business concepts.

* **Entities:** Objects with a unique identity. They represent core business concepts and contain specific behaviors.

* **Value Objects:** Objects without a unique identity, defined by their attributes and immutable. They are used to represent descriptive data.

* **Aggregates:** Clusters of related entities and value objects treated as a single unit, with a designated root entity. They enforce business rules by ensuring all changes go through the root.

* **Domain Services:** Operations that don't fit naturally within a single entity, often coordinating multiple entities or aggregates. They orchestrate complex business workflows.

* **Repository Interfaces (ports):** Contracts for data persistence. Their implementations reside in the infrastructure layer, ensuring the domain remains isolated.

---

### Infrastructure Module

The `infrastructure` module contains the data persistence layer. 
This module is separated by both database and company. 
Each module includes everything needed for database management:

* Database connection and management
* Entities
* Mappers (using MapStruct) between domain objects and entities
* Adapters for data persistence
* Test environment (if applicable)

The persistence module is designed to be fully isolated, making it easy to remove or replace the persistence layer if needed.
