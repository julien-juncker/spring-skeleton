# Spring skeleton
This project allow you to quickly implement Spring boot stack with : 
- Spring boot 3.4.4
- Java 21
- Mapstruct
- Karate labs
- OpenApi generator

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
    - `docapi/static/openapi.yaml`
  - Remove from controller module
    - `src/main/java/com/spring/skeleton/controller/PetStoreController.java`
  - Remove from domain module
    - `src/main/java/com/spring/skeleton/domain/petstore/PetStoreService.java`
    - `src/main/java/com/spring/skeleton/domain/petstore/object/Pet.java`