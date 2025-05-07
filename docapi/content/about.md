+++
title = "About"
date = "2025-04-28"
author = "julien-juncker"
+++

# Spring skeleton
This project allow you to quickly implement Spring boot stack with :
- Spring boot 3.4.4
- Flyway
- Java 21
- Mapstruct
- Karate labs
- OpenApi generator
- TestContainer

This project respect D.D.D principles.

## How to use this stack to build another one
You can fork this project and follow the steps bellow.

### Rename the stack com.spring.skeleton by your stack name
- Rename on Each module
    - apps and domain modules
    - It's better to use refactoring technique from your IDE
- Rename "groupId" and "artifactId" on global pom
- Rename "groupId" and "artifactId" on parent block for apps pom
- Rename "apiPackage" - "modelPackage" - "invokerPackage" openApi configuration on apps pom
    - Path on pom.xml : `project -> build -> plugins -> plugin with groupId org.openapitools -> executions -> execution -> configuration`

### Remove or replace useless Petstore feature
- Remove from openApi file
    - `docapi/static/openapi.yaml` only petstore references
- Remove from controller package in apps module
    - `apps/src/main/java/com/spring/skeleton/controller/PetStoreController.java` all file
- Remove from model package in apps module
  - `apps/src/main/java/com/spring/skeleton/model/**` all files
- Remove from domain module
    - `domain/src/main/java/com/spring/skeleton/domain/petstore/PetStoreService.java` all file
    - `domain/src/main/java/com/spring/skeleton/domain/petstore/object/Pet.java` all file
- Rename petstore DB docker container name
  - `docker/docker-compose.yaml` only l.5
- Remove sql init script from flyway and test
  - `apps/src/main/resources/db_migration/V0.2__init_petstore.sql` all file
  - `apps/src/test/resources/sql/init_petstore.sql` all file
  - `apps/src/test/java/com/spring/skeleton/apps/configuration/ApplicationStub.java` only l.12
  - `apps/src/test/resources/sql/truncate.sql` only l.1