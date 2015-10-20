# ORM-and-JPA
Project Summary

The project is to implement the use of object-relational mapping (ORM) and the Java Persistence API (JPA) by designing and implementing a domain model with basic EntityManager functionality.

In domain structure our projects using maven, add dependencies using the pom.xml configuration file, and make use of JUnit test cases..

It consists of 1 maven Java Application project using JPA and MySQL database connectivity.  There are 6 Entity classes in project.
Design

    The project contains Multilevel Marketing Company which include 6 entities Customer,Member,Products,Company,Points and Combos.  
    The functionality implement in the project is based on JPA and ORM , so it is very easy to add or remove components later on if we want to expand the project.
    I used the database "itmd4515" in which there are total nine(9) tables from that six(6) are entities and other three(3) are Join table of these entities.
    When the project test, there are four(4) test cases like Create,Read,Update and Delete. I used test files for each entities to create this test cases.
    I have performed the extra credit work which is to create workbench to Use MySQL Workbench to reverse engineer my database to an EER/ERD model. I Included a screenshot of my model in this Readme page.
    To run the main project just test the jsharma3-mp3 project .
    There are two abstract class which content all common method of class when abstract class of test package is use to call the entity and to create the value in database.

Development Insights

    Before working on project ,i was not familiar with JPA, ORM and having a no knowledge about Hibernate , But once I started I found very interesting to work with hibernate and  get more familiar with it .
    I learned about JPA , JUnit and their interaction with each other using Hibernate.
    After working on project I like JPA and want to learn more about Hibernate .
    JUnit testing is easy.

Requirements (Installation, Compile, Run-time, etc)

    Open the project in Net-beans.
    Connect the database "itmd4515" with the user "itmd4515" and password "itmd4515".
    Database tables created by test cases of project.
    And test the project and you will see the all tables of the database in mysql with values.
    The Tools used in the project is "NetBeans IDE version 8.0.2"
    The Project is  based on JPA,ORM and Hibernate. The libraries used are sql,util,annotation,ejb,inject,validation,OneToOne,ManyToMany,ManyToOne,OneToMany.
