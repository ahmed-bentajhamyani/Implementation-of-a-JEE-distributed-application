<p align="center">
	<img src="https://user-images.githubusercontent.com/101653735/202849820-dfeaabcf-4dd9-4452-a847-5a767462fd9d.png" >
</p>

# Implementation of a JEE distributed application

This is an implementation of a distributed application using EJB3 technology.

**Tools :** Eclipse, Maven, Tomcate, MySQL, JPA, EJB, WildFly.

## Table of contents
[Class diagram](#class-diagram)

[Testing the Application](#testing-the-application)
* [Products](#products)
* [Login](#login)
* [Signup](#signup)
* [Shopping Cart](#shopping-cart)
* [Logout](#logout)

## Installation of JBoss Tools plugin



## Installation of JBoss Tools plugin

We installed the JBoss Tools plugin from the Eclipse Marketplace:

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/205165675-a0d7e6b8-99db-4ee4-af24-ad30a92aa339.png">
</p>

## Configuration of WildFly's Datasource

First we downloaded MySQL Connector .jar file and put it in a new repository we create in ```wildfly-27.0.0.Final\modules\system\layers\base\com``` with the name mysql and we create also the ```modules.xml``` inside it we put this code :

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

We create the data source in the WildFly Administration Console :

<p align="center">
  <img width="925" alt="7" src="https://user-images.githubusercontent.com/101653735/205167970-d52f7ef0-dd6e-44c0-b007-d860ba2fc406.png">
</p>

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

### Products
