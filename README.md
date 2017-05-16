# Eureka! Clinical Service Archetype

## Version 1.0 development series
Latest release: [![Latest release](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-service-archetype/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-service-archetype)

## Version history
No final releases yet

## What does it do?
This project is an maven archetype that helps you create a base eurekaclinical service project that you can build on. A working service project created based on this archetype implements required User and Roles resources and entity objects as well as a liquibase changelog file that creates the corresponding tables. A test resource is included for testing purposes. 

## Requirements
* [Oracle Java JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Maven 3.2.5 or greater](https://maven.apache.org)

## How to use it
The project can be created as follows:

1) Run the following command, after changing the -DartifactId name to the name of your new project and the -DarchetypeVersion to the version of the archetype that you want to use.
```
mvn archetype:generate -DarchetypeGroupId=org.eurekaclinical -DarchetypeArtifactId=eurekaclinical-service-archetype -DarchetypeVersion=version -DgroupId=org.eurekaclinical -DartifactId=eurekaclinical-microservicename-service -Dpackage=org.eurekaclinical.package -DdataSource=EurekaClinicalMicroserviceNameService -DpropertyNamespace=eurekaclinical.microservicename -DshortNamespace=ec-microservicename
```
Alternatively, run the following and answer the prompts:
```
mvn archetype:generate -DarchetypeGroupId=org.eurekaclinical -DarchetypeArtifactId=eurekaclinical-service-archetype -DarchetypeVersion=1.0-Alpha-3-SNAPSHOT
```
2) When prompted, specify an initial version of your new project, such as 1.0-SNAPSHOT.
3) Confirm the package name when prompted.
4) A folder with the new project should be created in the current directory, which in this example would be eurekaclinical-microservicename-service. Type `cd eurekaclinical-projectname-service`.
5) To generate an initial NOTICE file, type `mvn notice:generate`. You will need to rerun this command whenever the project's dependencies change.
6) Change the module-name property in the pom.xml to the name of the module you are trying to implement. Keep this consistent with the corresponding webapp project if you want them both to use the same application.properties. Also the service URL's and webapp URL's for the module are looked up based on this property in WebappProperties class.

The resulting service project will be buildable using `mvn clean install` and runnable using `mvn tomcat7:run -Ptomcat`. After running, go to your web browser and navigate to `https://localhost:8443/project-name/api/protected/test`. You should see `Hello World`.
