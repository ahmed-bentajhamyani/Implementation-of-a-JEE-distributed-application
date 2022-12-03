<p align="center">
	<img src="https://user-images.githubusercontent.com/101653735/202849820-dfeaabcf-4dd9-4452-a847-5a767462fd9d.png" >
</p>

# Implementation of a JEE distributed application

This is an implementation of a distributed application using EJB3 technology.

**Tools :** Eclipse, Maven, Tomcate, MySQL, JPA, EJB, WildFly.

## Table of contents
[Installation of JBoss Tools plugin](#installation-of-jBoss-tools-plugin)
[Configuration of WildFly's Datasource](#configuration-of-wildFly's-datasource)

[Testing the Application](#testing-the-application)
* [Etudiants List](#etudiants-list)
* [Add Etudiant](#add-etudiant)
* [Update Etudiant](#update-etudiant)
* [Delete Etudiant](#delete-etudiant)

## Installation of JBoss Tools plugin

We installed the JBoss Tools plugin from the Eclipse Marketplace:

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/205165675-a0d7e6b8-99db-4ee4-af24-ad30a92aa339.png">
</p>

## Configuration of WildFly's Datasource

First we downloaded MySQL Connector .jar file and put it in a new repository we create in ```wildfly-27.0.0.Final\modules\system\layers\base\com``` with the name ```mysql\main``` and we create also the ```modules.xml``` inside it we put this code :

```
<?xml version="1.0" encoding="UTF-8"?>
<module name="com.mysql" xmlns="urn:jboss:module:1.9">
    <resources>
        <resource-root path="mysql-connector-java-8.0.30.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
    </dependencies>
</module>
```
We add the driver tag of mysql in the ```standalone.xml``` file in ```wildfly-27.0.0.Final\standalone\configuration``` repository :


```
<driver name="mysql" module="com.mysql"/>
```

In ```standalone.xml```, just above the driver snippet, we add this datasoure snippet:

```
<datasource jndi-name="java:/EtudiantDS" pool-name="EtudiantDS">
	<connection-url>jdbc:mysql://localhost:3306/getudiants
	</connection-url>
	<driver>mysql</driver>
	<security>
		<user-name>root</user-name>
		<password></password>
	</security>
	<validation>
		<valid-connection-checker
			class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker" />
		<background-validation>true</background-validation>
		<exception-sorter
			class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter" />
	</validation>
</datasource>
```

And add the  ```persistence.xml``` file in ```META-INF``` repository of the EJB project :

```
<?xml version="1.0" encoding="UTF-8" ?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="2.2"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
	<persistence-unit name="Etudiant" transaction-type="JTA">
		<jta-data-source>java:/EtudiantDS</jta-data-source>
		<class>ma.fstt.persistence.Etudiant</class>
		<properties>
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect" />
			<property name="hibernate.hbm2ddl.auto" value="create" />
		</properties>
	</persistence-unit>
</persistence>
```

## Testing the Application

### Etudiants List

In the first time the list of etudiants is empty:

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/205465195-cd223d0a-5107-410a-b228-bc7920446b79.png">
</p>

### Add Etudiant

We added a new etudiant:

<p align="center">
	<img width="960" alt="2" src="https://user-images.githubusercontent.com/101653735/205465208-6ccdb91a-35a3-4767-bd97-75ac9de9d7fb.png">
</p>

And after we click on save:

<p align="center">
	<img width="960" alt="3" src="https://user-images.githubusercontent.com/101653735/205465335-424662a5-7d96-4ef9-b00d-0d6079d2738e.png">
</p>

We can update or delete an etudiant.

### Update Etudiant

We click on edit link:

<p align="center">
	<img width="960" alt="4" src="https://user-images.githubusercontent.com/101653735/205465318-14ae3444-5152-4048-96b5-5b90817fc47e.png">
</p>

And we click on save:

<p align="center">
	<img width="960" alt="5" src="https://user-images.githubusercontent.com/101653735/205465361-c27cce0c-ec75-4849-85b8-5d91185b83f5.png">
</p>

### Delete Etudiant

We click on delete link to delete the etudiant we just create:

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/205465375-18ab7b29-935d-4f72-8b9d-9eca38b830c0.png">
</p>
