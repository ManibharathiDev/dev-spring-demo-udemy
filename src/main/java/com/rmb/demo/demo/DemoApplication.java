package com.rmb.demo.demo;

import com.rmb.demo.demo.dao.StudentDAO;
import com.rmb.demo.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.ArrayList;
import java.util.List;
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

            do {
                Scanner sc = new Scanner(System.in);
                System.out.println("1 : Create");
                System.out.println("2 : Read");
                System.out.println("3 : Update");
                System.out.println("4 : Delete");
                System.out.println("5 : Find By Last Name");
                System.out.println("6 : Delete All1 ");
                System.out.println("Enter your option");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        createStudent(studentDAO);
                        break;
                    case 2:
                        readStudent(studentDAO);
                        break;
                    case 3:
                        updateStudent(studentDAO);
                        break;
                    case 4:
                        deleteStudent(studentDAO);
                        break;
                    case 5:
                        readStudentByLastName(studentDAO);
                        break;
                    case 6:
                        deleteAll(studentDAO);
                        break;
                    default:
                        System.out.println("Invalid");
                }
            } while (true);


            //createStudent(studentDAO);
        };
    }

    private void deleteAll(StudentDAO studentDAO)
    {
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println(numRowsDeleted +" Rows Deleted");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        ArrayList<Student> studentArrayList = studentDAO.studentList();
        for(Student curr : studentArrayList)
        {
            System.out.println(curr);
        }
        System.out.println("Enter the ID that you wish to delete");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();

        boolean isFound = false;
        Student foundStudent = null;
        for(Student curr : studentArrayList)
        {
            if(curr.getId() == id)
            {
                isFound = true;
                foundStudent = curr;
                break;
            }
        }
        if(!isFound)
        {
            System.out.println("No student found!, Please enter valid id");
            return;
        }

        System.out.println("Deleting...");
        studentDAO.delete(foundStudent.getId());
        System.out.println("Student Data is Deleted");
    }

    private void updateStudent(StudentDAO studentDAO) {
        ArrayList<Student> studentArrayList = studentDAO.studentList();
        for(Student curr : studentArrayList)
        {
            System.out.println(curr);
        }
        System.out.println("Enter the ID that you wish to update");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();

        boolean isFound = false;
        Student foundStudent = null;
        for(Student curr : studentArrayList)
        {
            if(curr.getId() == id)
            {
                isFound = true;
                foundStudent = curr;
                break;
            }
        }



        if(!isFound)
        {
            System.out.println("No student found!, Please enter valid id");
            return;
        }

        System.out.println("Stored details are");
        System.out.println(foundStudent);
        System.out.println("Update Option");
        System.out.println("1 : First Name");
        System.out.println("2 : Second Name");
        System.out.println("3 : Email");
        System.out.println("Enter your update option");
        int updateOption = sc.nextInt();
        sc.nextLine();
        if (updateOption == 1) {
            System.out.println("Enter the First Name");
            String fName = sc.nextLine();
            foundStudent.setFirstName(fName);
            System.out.println("Updating...");
            studentDAO.update(foundStudent);
            System.out.println("Student updated");
        }
        else if(updateOption == 2)
        {
            System.out.println("Enter the Last Name");
            String lName = sc.nextLine();
            foundStudent.setLastName(lName);
            System.out.println("Updating...");
            studentDAO.update(foundStudent);
            System.out.println("Student updated");
        }
        else if(updateOption == 3)
        {
            System.out.println("Enter the Email");
            String email = sc.nextLine();
            foundStudent.setEmail(email);
            System.out.println("Updating...");
            studentDAO.update(foundStudent);
            System.out.println("Student updated");
        }
        else
            System.out.println("Invalid Option!");


    }

    private void readStudent(StudentDAO studentDAO) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student id");
        int id = sc.nextInt();
        Student student = studentDAO.findById(id);
        if(student != null)
        {
            System.out.println("ID : "+student.getId());
            System.out.println("Name : "+student.getFirstName()+" "+student.getLastName());
            System.out.println("Email : "+student.getEmail());
            return;
        }
        System.out.println("No Student Found! Invalid ID");

    }

    private static void readStudentByLastName(StudentDAO studentDAO)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student Last Name");
        String lastName = sc.nextLine();

        List<Student> theStudents = studentDAO.findBylastName(lastName);
        for(Student stu : theStudents)
        {
            System.out.println(stu);
        }

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
