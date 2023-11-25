package com.rmb.demo.demo;

import com.rmb.demo.demo.dao.StudentDAO;
import com.rmb.demo.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
    {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private static void createStudent(StudentDAO studentDAO)
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name");
        String firstName = sc.nextLine();

        System.out.println("Enter the Last Name");
        String lastName = sc.nextLine();

        System.out.println("Enter the email");
        String email = sc.nextLine();
        Student student = new Student(firstName,lastName,email);
        System.out.println("Saving Student");
        studentDAO.save(student);
        System.out.println("Student Saved, ID is => "+student.getId());


//        // Create a Student Object
//        Student student = new Student("Manibharathi","R","manibharath159@gmail.com");
//        System.out.println("Saving Student");
//        // Save a Student Object
//        studentDAO.save(student);
//
//        // Print a saved Student ID
//        System.out.println("Student Saved, ID is => "+student.getId());
    }

}
