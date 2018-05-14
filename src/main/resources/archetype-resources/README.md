#set($hash = '#')
${hash} ${artifactId}
[Georgia Clinical and Translational Science Alliance (Georgia CTSA)](http://www.georgiactsa.org), [Emory University](http://www.emory.edu), Atlanta, GA

${hash}${hash} What does it do?
Write a description here

${hash}${hash} Version 1.0 development series
Latest release: [![Latest release](https://maven-badges.herokuapp.com/maven-central/${groupId}/${artifactId}/badge.svg)](https://maven-badges.herokuapp.com/maven-central/${groupId}/${artifactId})

## Version history
No final releases yet

${hash}${hash} Build requirements
* [Oracle Java JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Maven 3.2.5 or greater](https://maven.apache.org)

${hash}${hash} Runtime requirements
* [Oracle Java JRE 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Tomcat 7](https://tomcat.apache.org)
* One of the following relational databases:
  * [Oracle](https://www.oracle.com/database/index.html) 11g or greater
  * [PostgreSQL](https://www.postgresql.org) 9.1 or greater
  * [H2](http://h2database.com) 1.4.193 or greater (for testing)

${hash}${hash} REST endpoints

${hash}${hash}${hash} `/api/protected/users`
Manages registering a user with this service for authorization purposes.

${hash}${hash}${hash}${hash} Role-based authorization
Call-dependent

${hash}${hash}${hash}${hash} Requires successful authentication
Yes

${hash}${hash}${hash}${hash} User object
Properties:
* `id`: unique number identifying the user (set by the server on object creation, and required thereafter).
* `username`: required username string.
* `roles`: array of numerical ids of roles.

${hash}${hash}${hash}${hash} Calls
All calls use standard names, return values and status codes as specified in the [Eureka! Clinical microservice specification](https://github.com/eurekaclinical/dev-wiki/wiki/Eureka%21-Clinical-microservice-specification)

${hash}${hash}${hash}${hash}${hash} GET `/api/protected/users`
Returns an array of all User objects. Requires the `admin` role.

${hash}${hash}${hash}${hash}${hash} GET `/api/protected/users/{id}`
Returns a specified User object by the value of its id property, which is unique. Requires the `admin` role to return any user record. Otherwise, it will only return the user's own record.

${hash}${hash}${hash}${hash}${hash} GET `/api/protected/users/byname/{username}`
Returns a specified User object by its username, which is unique. Requires the `admin` role to return any user record. Otherwise, it will only return the user's own record.

${hash}${hash}${hash}${hash}${hash} GET `/api/protected/users/me`
Returns the User object for the currently authenticated user.

${hash}${hash}${hash}${hash}${hash} POST `/api/protected/users/`
Creates a new user. The User object is passed in as the body of the request. Returns the URI of the created User object. Requires the `admin` role.

${hash}${hash}${hash}${hash}${hash} PUT `/api/protected/users/{id}`
Updates the user object with the specified id. The User object is passed in as the body of the request. Requires the `admin` role.

${hash}${hash}${hash} `/api/protected/roles`
Manages roles for this service. It is read-only.

${hash}${hash}${hash}${hash} Role-based authorization
No.

${hash}${hash}${hash}${hash} Requires successful authentication
Yes

${hash}${hash}${hash}${hash} Role object
Properties:
* `id`: unique number identifying the role.
* `name`: the role's name string.

${hash}${hash}${hash}${hash} Calls
All calls use standard names, return values and status codes as specified in the [Eureka! Clinical microservice specification](https://github.com/eurekaclinical/dev-wiki/wiki/Eureka%21-Clinical-microservice-specification)

${hash}${hash}${hash}${hash}${hash} GET `/api/protected/roles`
Returns an array of all User objects.

${hash}${hash}${hash}${hash}${hash} GET `/api/protected/roles/{id}`
Returns a specified Role object by the value of its id property, which is unique.

${hash}${hash}${hash}${hash}${hash} GET `/api/protected/roles/byname/{name}`
Returns a specified Role object by its name, which is unique.

${hash}${hash} Building it
The project uses the maven build tool. Building for the first time is typically done by invoking `mvn clean notice:generate install`. For subsequent builds, `mvn clean install` can be invoked on the command line. For simple file changes, not additions or deletions, you can usually use `mvn install`. See https://github.com/eurekaclinical/dev-wiki/wiki/Building-Eureka!-Clinical-projects for more details.

${hash}${hash} Performing system tests
You can run this project in an embedded tomcat by executing `mvn process-resources cargo:run -Ptomcat` after you have built it. It will be accessible in your web browser at https://localhost:8443/${artifactId}/. Your username will be `superuser`.

${hash}${hash} Installation
${hash}${hash}${hash} Database schema creation
A [Liquibase](http://www.liquibase.org) changelog is provided in `src/main/resources/dbmigration/` for creating the schema and objects. [Liquibase 3.3 or greater](http://www.liquibase.org/download/index.html) is required.

Perform the following steps:
1) Create a schema in your database and a user account for accessing that schema.
2) Get a JDBC driver for your database and put it the liquibase lib directory.
3) Run the following:
```
./liquibase \
      --driver=JDBC_DRIVER_CLASS_NAME \
      --classpath=/path/to/jdbcdriver.jar:/path/to/${artifactId}.war \
      --changeLogFile=dbmigration/changelog-master.xml \
      --url="JDBC_CONNECTION_URL" \
      --username=DB_USER \
      --password=DB_PASS \
      update
```
4) Add the following Resource tag to Tomcat's `context.xml` file:
```
<Context>
...
    <Resource name="jdbc/${dataSource}" auth="Container"
            type="javax.sql.DataSource"
            driverClassName="JDBC_DRIVER_CLASS_NAME"
            factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
            url="JDBC_CONNECTION_URL"
            username="DB_USER" password="DB_PASS"
            initialSize="3" maxActive="20" maxIdle="3" minIdle="1"
            maxWait="-1" validationQuery="SELECT 1" testOnBorrow="true"/>
...
</Context>
```

The validation query above is suitable for PostgreSQL. For Oracle and H2, use
`SELECT 1 FROM DUAL`.

${hash}${hash}${hash} Configuration
This service is configured using a properties file located at `/etc/${shortNamespace}/application.properties`. It supports the following properties:
* `${propertyNamespace}.callbackserver`: https://hostname:port
* `${propertyNamespace}.url`: https://hostname:port/${artifactId}
* `cas.url`: https://hostname.of.casserver:port/cas-server

A Tomcat restart is required to detect any changes to the configuration file.

${hash}${hash}${hash} WAR installation
1) Stop Tomcat.
2) Remove any old copies of the unpacked war from Tomcat's webapps directory.
3) Copy the warfile into the tomcat webapps directory, renaming it to remove the version. For example, rename `${artifactId}-${version}.war` to `${artifactId}.war`.
4) Start Tomcat.

${hash}${hash} Maven dependency
```
<dependency>
    <groupId>${groupId}</groupId>
    <artifactId>${artifactId}</artifactId>
    <version>${version}</version>
</dependency>
```

${hash}${hash} Developer documentation
* [Javadoc for latest development release](http://javadoc.io/doc/${groupId}/${artifactId}) [![Javadocs](http://javadoc.io/badge/${groupId}/${artifactId}.svg)](http://javadoc.io/doc/${groupId}/${artifactId})

${hash}${hash} Getting help
Feel free to contact us at help@eurekaclinical.org.

