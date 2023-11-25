## Running Springboot in two ways
Running Springboot app in two ways without using IDE
1. Using Jar
    - Create Package: mvnw package
    - running jar:java -jar .jar
2. Using SpringBoot run
    - mvnw spring-boot:run

## 07 Server Configuration
## Spring Boot core
## 08 Inversion Of Control - Dependency Injection
    Two Types of Injection
    1. Constructor Injection
    2. Setter Injection

## 09 Set Component Scanning
Spring boot scan component only own packages not for other package
If you want, scan all packages you should be added scanBasePackages in Main Class

## 10 Setter Injection

## 11 Field Injection : Not recommended by the spring.io development team
    Field Injection ... no longer cool

## 12 Qualifier

If we implements coach in multiple class, we get following error

### Description:
```
    Parameter 0 of method setCoach in com.rmb.demo.demo.rest.CoachController required a single bean, but 4 were found:
	- baseBallCoach: defined in file [E:\Manibharathi\dev-spring-boot\SpringBootApp\target\classes\com\rmb\demo\demo\common\BaseBallCoach.class]
	- cricketCoach: defined in file [E:\Manibharathi\dev-spring-boot\SpringBootApp\target\classes\com\rmb\demo\demo\common\CricketCoach.class]
	- tennisCoach: defined in file [E:\Manibharathi\dev-spring-boot\SpringBootApp\target\classes\com\rmb\demo\demo\common\TennisCoach.class]
	- trackCoach: defined in file [E:\Manibharathi\dev-spring-boot\SpringBootApp\target\classes\com\rmb\demo\demo\common\TrackCoach.class]
```
    We can avoid this by using @Qualifier Annotation

## 13 We can use @Primary annotation to which one is primary

## 13 Lazy-Initialization : The bean only initialized when we need

## 14 Bean Scopes / Bean Lifecycles

In Default, All beans are singleton

    Prototype = ConfigurableBeanFactory.SCOPE_PROTOTYPE
    Singleton = ConfigurableBeanFactory.SCOPE_SINGLETON

## Bean Lifecycle 
    @PostConstruct : Do my stuff when application started
    @PreDestroy : Do my stuff when application terminate

## 15 Configure Beans

We introduce new class without add @Component annotations.
If we add that class to Controller, We get below error

      Description:

      Parameter 0 of constructor in com.rmb.demo.demo.rest.CoachController required a bean of type 'com.rmb.demo.demo.common.Coach' that could not be found.

      The injection point has the following annotations:
      - @org.springframework.beans.factory.annotation.Qualifier("swimCoach")

      The following candidates were found but could not be injected:
      - User-defined bean
        - User-defined bean
        - User-defined bean
        - User-defined bean

      Action:
      Consider revisiting the entries above or defining a bean of type 'com.rmb.demo.demo.common.Coach' in your configuration.

We can avoid this error using configuration beans.

```java
@Configuration
public class CoachConfig 
    {
         @Bean
         public Coach swimCoach()
         {
            return new SwimCoach();
         }
   }
```
   1. In Default method name is bean ID
   2. If you want to change bean ID mention in the @Bean annotation

## 16 Hibernate-JPA-MySQL With Command Line Tool
### Setup Database Connection
```property
spring.datasource.url=jdbc:mysql://localhost:3306/dbname
spring.datasource.username=username
spring.datasource.password=password
```