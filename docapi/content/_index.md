+++
title = "Spring skeleton"
date = "2025-04-28"
author = "julien-juncker"
+++

This project allows you to quickly set up a Spring Boot stack with the following technologies:
- Spring Boot 3.4.4
- Flyway
- Java 21
- MapStruct
- Karate Labs
- OpenAPI Generator
- TestContainers

This project follows Domain-Driven Design (DDD) principles.

## How to Use This Stack to Build Your Own

You can fork this project and follow the steps below.

### Rename the stack `com.spring.skeleton` to your own stack name

- Rename in each module:
  - `apps` and `domain` modules
  - It’s recommended to use your IDE’s refactoring tools for this
- Update `groupId` and `artifactId` in the global `pom.xml`
- Update `groupId` and `artifactId` in the parent section of the `apps` module `pom.xml`
- Update the OpenAPI configuration in the `apps` module `pom.xml`:
  - Change `apiPackage`, `modelPackage`, and `invokerPackage`
  - Path in `pom.xml`: `project -> build -> plugins -> plugin (groupId: org.openapitools) -> executions -> execution -> configuration`

### Remove or replace the unused Petstore feature

- Remove Petstore references from the OpenAPI file:
  - `docapi/static/openapi.yaml`
- Remove Petstore controller:
  - `apps/src/main/java/com/spring/skeleton/controller/PetStoreController.java` (entire file)
- Remove Petstore models:
  - `apps/src/main/java/com/spring/skeleton/model/**` (all files)
- Remove Petstore domain classes:
  - `domain/src/main/java/com/spring/skeleton/domain/petstore/PetStoreService.java` (entire file)
  - `domain/src/main/java/com/spring/skeleton/domain/petstore/object/Pet.java` (entire file)
- Rename the Petstore database Docker container:
  - In `docker/docker-compose.yaml` (only line 5)
- Remove Petstore SQL initialization scripts:
  - `apps/src/main/resources/db_migration/V0.2__init_petstore.sql` (entire file)
  - `apps/src/test/resources/sql/init_petstore.sql` (entire file)
  - Remove line 12 in `apps/src/test/java/com/spring/skeleton/apps/configuration/ApplicationStub.java`
  - Remove line 1 in `apps/src/test/resources/sql/truncate.sql`
