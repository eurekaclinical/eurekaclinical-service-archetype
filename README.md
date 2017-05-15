# Eureka! Clinical Service Archetype

## Version 1.0 development series
Latest release: [![Latest release](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-service-archetype/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-service-archetype)

## Version history
No final releases yet

## What does it do?
This project is an maven archetype that helps you create a base eurekaclinical service project that you can build on. A working service project created based on this archetype implements a required User and Roles resource and Entity objects as well as a liquibase changelog file that creates the required tables. A testResource is included for testing purposes. 

The project can be created as follows:

1) Change the -DartifactId name accordingly and the -DarchetypeVersion to version of the archetype that you want to use.
```
mvn archetype:generate -DarchetypeCatalog=local -DarchetypeGroupId=org.eurekaclinical -DarchetypeArtifactId=eurekaclinical-service-archetype -DarchetypeVersion=version -DgroupId=org.eurekaclinical -DartifactId=eurekaclinical-microservicename-service
```
2) Specify a version or enter when prompted with Define value for property 'version': 1.0-SNAPSHOT:
3) Confirm on package: org.eurekaclinical
4) A folder with the new project should be created in the current directory, which in this example would be eurekaclinical-microservicename-service. Type `cd eurekaclinical-projectname-service`.
5) To generate an initial NOTICE file, type `mvn notice:generate`. You will need to rerun this command whenever the project's dependencies change.
6) Change the module-name property in the pom.xml to the name of the module you are trying to implement. Keep this consistent with the corresponding webapp project if you want them both to use the same application.properties. Also the service URL's and webapp URL's for the module are looked up based on this property in WebappProperties class.

The resulting service project will be buildable using `mvn clean install` and runnable using `mvn tomcat7:run -Ptomcat`.
