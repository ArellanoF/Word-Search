# BACK-EE-NDS :bomb:
Proyect (ICC02_P7) **Aplicación backend con tecnologia Java en servidores de aplicaciones**

## INTRODUCTION :rocket:
***
"__Sopa Letras__" Game, developed in Java, with player authentication in LDAP

Mysql database where we store the different words and player scores
## VIDEO PRESENTATION :movie_camera:
***

## USER GUIDE :clipboard:
***
To access the application we must enter our LDAP server username and password configured in (ldap-data.ldif file)
![Login](https://github.com/hectoresquerdo/BACK-EE-NDS/blob/master/images/login.png)

Once we have entered the application, it will take us to the main screen, where we must enter the words we want to play with, this screen allows us to start the game by clicking on the Play button.

![Home](https://github.com/hectoresquerdo/BACK-EE-NDS/blob/master/images/home.png)

When you click on the play button, the application shows the game window, where we can see the alphabet soup and on the right a column with the words to find

![Play](https://github.com/hectoresquerdo/BACK-EE-NDS/blob/master/images/play.png)

When we find a word, we position ourselves with the mouse on the first letter of the word and by pressing the right mouse button we will drag until all the letters that compose it are selected, while the selection is made, the letters are shown in orange

![Orange](https://github.com/hectoresquerdo/BACK-EE-NDS/blob/master/images/orange.png)

At the end of the selection, if done correctly, the word will turn blue and will be crossed out from the right column

![Blue](https://github.com/hectoresquerdo/BACK-EE-NDS/blob/master/images/blue.png)

If you find all of them, the board appears with a green background and the words found highlighted in white

![Green](https://github.com/hectoresquerdo/BACK-EE-NDS/blob/master/images/green.png)

Once all the words have been found, we press the solve button, a table with the scores will appear

![Finish](https://github.com/hectoresquerdo/BACK-EE-NDS/blob/master/images/finish.png)

To play again, just press the NEW GAME button again.
#### TOOLS :hammer_and_wrench:
***
- [Eclipse](https://www.eclipse.org) - IDE for Enterprise Java Developers
- [Spring Boot](https://spring.io/projects/spring-boot) - Spring Framework is an application framework and inversion of control container for the Java platform
- [JDBC](https://docs.microsoft.com/es-es/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15) - API that allows the execution of operations on databases from the Java programming language
- [JDK](https://www.oracle.com/es/java/technologies/javase-downloads.html) - Java SE Development 
- [Maven](https://maven.apache.org/) - Software tool for the management and construction of Java projects
- [Apache Tomcat](http://tomcat.apache.org/) - Server Aplication
- [Open LDAP](https://www.openldap.org/) - Independent communication protocol
- [MySQL Workbench](https://www.mysql.com/products/workbench/) - Visual database design tool that integrates software development, database administration, database design, management and maintenance for the MySQL database system
- [Bootstrap](https://getbootstrap.com/) - Cross-platform library or open source toolkit for website design and web applications

#### RUNNING THE PROTOTYPE :computer:
***
- Git clone this repo
- Import Dump database
- Run Spring Boot Application
- Run Apache Server (Mysql)
- Open browser on http://localhost:8080/

#### AUTHORS :monkey:
***
- __Héctor Esquerdo Valverde__            🐛[Git account](https://github.com/hectoresquerdo) 🐛
- __Gerard Márquez Rodríguez__            🐛[Git account](https://github.com/gmarquezro) 🐛
- __Toni Estirado Sanchez__               🐛[Git account](https://github.com/testirado) 🐛
- __Francesc Arellano Cachopo__           🐛[Git account](https://github.com/aretek88) 🐛
#### WITH GRATITUD :tada:
***
:hammer: :wrench::hammer: :wrench: To [Paco Gómez Arnal](https://www.youtube.com/c/PacoGomez), UOC consultant, and our guide in this project :hammer: :wrench::hammer: :wrench:


