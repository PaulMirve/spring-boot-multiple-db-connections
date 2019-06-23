# Multiple MySQL databases using Spring Boot
In this applicaton I configure two local databases for a Spring Boot app. I use Sakila and World databases, two databases that the MySQL page give us to practice.
<br>
 This is done thanks to the **@Configuration** bean that Spring Boot give us.
<br>
 A better explanation of this repository and how to establish multiple connection to an Spring Boot app can be found in my personal blog in this link: http://paulmirve.pythonanywhere.com/post/24 .
 
 ## How to run this project?
 The only thing you have to do is to update the database connections on the **application.properties** file.
 <br>
 In the case that you want to use your own databases instead of the example ones in this porject, you have to change the beans names on the **Configuration** folder classes to the names of your databases, the repositories, and the controllers. 
