# Eureka! Clinical Service Archetype
[Atlanta Clinical and Translational Science Institute (ACTSI)](http://www.actsi.org), [Emory University](http://www.emory.edu), Atlanta, GA

## What does it do?
This project is a maven archetype that creates a base Eureka! Clinical service with User and Roles resources, entity objects, 
and a liquibase changelog file that creates the corresponding tables. An additional `test` resource is included.

## Version 1.0 development series
Latest release: [![Latest release](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-service-archetype/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-service-archetype)

## Version history
No final releases yet

## Requirements
* [Oracle Java JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Maven 3.2.5 or greater](https://maven.apache.org)

## How to use it
The project can be created as follows:

1) Run the following command with your own values for the properties from `archetypeVersion` on down in the example below.
```
mvn archetype:generate -DarchetypeGroupId=org.eurekaclinical \
    -DarchetypeArtifactId=eurekaclinical-service-archetype \
    -DarchetypeVersion=version \
    -DgroupId=org.eurekaclinical \
    -DartifactId=eurekaclinical-microservicename-service \
    -Dpackage=org.eurekaclinical.packagename \
    -DdataSource=EurekaClinicalMicroserviceNameService \
    -DpropertyNamespace=eurekaclinical.microservicename \
    -DshortNamespace=ec-microservicename \
    -DinceptionYear=four-digit-year \
    -Dversion=1.0-SNAPSHOT
```
Alternatively, run the following and answer the prompts:
```
mvn archetype:generate -DarchetypeGroupId=org.eurekaclinical \
    -DarchetypeArtifactId=eurekaclinical-service-archetype \
    -DarchetypeVersion=version
```
The `groupId`, `artifactId`, `version`, and `package` properties are standard maven properties that specify the groupId,
artifactId and version of the resulting maven project, and the package that all of the project's classes will go in.
The initial version should be `1.0-SNAPSHOT`. The other properties are specific to Eureka! Clinical:
* `dataSource`: the name of the last part of the JNDI data source (i.e., the part after `java:comp/env/jdbc/`) 
for connecting to the service's database. For example, with the value `EurekaClinicalMicroserviceNameService`, the
JNDI data source name would be `java:comp/env/jdbc/EurekaClinicalMicroserviceNameService`.
* `propertyNamespace`: the first part of all of this service's property names in this service's `application.properties`
file. We namespace the property names anticipating a future where the properties will go into a central registry.
* `shortNamespace`: currently used as the name of the directory for the service's application.properties file, and
as the name of the service's logfile. For Eureka! Clinical core projects, we use the `ec` prefix instead of
`eurekaclinical` for brevity. This property is deprecated.
* `inceptionYear`: the four-digit year in which the service's initial release is anticipated. The value that you
specify here goes into the `inceptionYear` tag in the resulting maven project's pom.xml, and it also goes into the
`etc/NOTICE.template` file.

 
All Eureka! Clinical core projects should follow the naming convention in the first example above, 
replacing `microservicename` or `MicroserviceName` with a name for your new service with corresponding capitalization.
Projects that are deployment-specific should have their own groupId, and the artifactId should begin with an identifier
for your deployment, e.g., `emory` instead of `eurekaclinical` for services that are specific to a deployment at
Emory University. 

2) A folder with the new project should be created in the current directory, which in this example would be 
eurekaclinical-microservicename-service. Type `cd eurekaclinical-microservicename-service`.
3) To generate an initial NOTICE file, type `mvn notice:generate`. You will need to rerun this command whenever the 
project's dependencies change.

The resulting service project will be buildable using `mvn clean install` and runnable using `mvn tomcat7:run -Ptomcat`. 
After running, go to your web browser and navigate to `https://localhost:8443/eurekaclinical-microservicename-service/api/protected/test`. 
You should see `Hello World`.
