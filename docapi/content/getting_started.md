+++
title = "Getting started"
date = "2025-04-28"
author = "julien-juncker"
weight = 2
+++

## How to Use This Stack to Build Your Own

You can fork this project and follow the steps below.

### Rename the stack `com.spring.skeleton` to your own stack name

- Rename in each module:
    - `apps`, `domain` and all `infrastructure` modules
    - It’s recommended to use your IDE’s refactoring tools for this
- Update `groupId` and `artifactId` in the global `pom.xml`
- Update `groupId` and `artifactId` in the parent section of all children modules `pom.xml` (`apps`, `domain` ...)

### Remove or replace the unused Petstore feature

- Remove Petstore references from the OpenAPI file:
    - `docapi/content/openapi.yaml`
- Remove all Petstore files from :
    - apps module
    - domain module
- Remove Petstore infrastructures module (pet-infrastructure, petstore infrastructure).
- Rename Pet and Petstore databases Docker container:
    - In `docker/docker-compose.yaml`