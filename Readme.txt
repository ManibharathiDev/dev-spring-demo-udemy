Running sprinboot app in two ways without using IDE
1. Using Jar
    Create Package: mvnw package
    running jar:java -jar .jar
2. Using SpringBoot run
    mvnw spring-boot:run

#07 Server Configuration
# Spring Boot core
###############################################
#08 Inversion Of Control - Dependency Injection
    Two Types of Injection
    1. Constructor Injection
    2. Setter Injection

# 09 Set Component Scanning
Spring boot scan component only own packages not for other package
If you want, scan all packages you should be added scanBasePackages in Main Class

# 10 Setter Injection

# 11 Field Injection : Not recommended by the spring.io development team
    Field Injection ... no longer cool
