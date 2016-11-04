This project is an maven archetype that helps you create a base eurekaclinical service project that you can build on. A working service project created based on this archetype implements a required User and Roles resource and Entity objects as well as a liquibase changelog file that creates the required tables. A testResource is included for testing purposes. 

The project can be created using the following command. Change the -DartifactId name accordingly and the -DarchetypeVersion to version of the archetype that you want to use.

mvn archetype:generate -DarchetypeCatalog=local -DarchetypeGroupId=org.eurekaclinical -DarchetypeArtifactId=eurekaclinical-service-archetype -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=org.eurekaclinical -DartifactId=eurekaclinical-projectname-service

specify a version or enter when prompted with Define value for property 'version': 1.0-SNAPSHOT:

Confirm on package: org.eurekaclinical

A folder with the new project should be created in the current directory. In this example: eurekaclinical-projectname-service 
type cd eurekaclinical-projectname-service

type mvn notice:generate

Change the module-name property in the pom.xml to the name of the module you are trying to implement. Keep this consistent with the corresponding webapp project if you want them both to use the same application.properties. Also the service URL's and webapp URL's for the module are looked up based on this property in WebappProperties class.

This project can be tested before you build on it using embedded tomcat. change the application.properties values accordingly.
