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
- Rename "groupId" and "artifactId" on parent block for all children pom (apps, domain ...).

### Remove or replace useless Petstore feature
- Remove from openApi file
    - `docapi/content/openapi.yaml` only petstore references
- Remove all Petstore files from :
  - apps module
  - domain module
- Remove Petstore infrastructures module (pet-infrastructure, petstore infrastructure).
- Remove pet and petstore DB docker container name
  - `docker/docker-compose.yaml`