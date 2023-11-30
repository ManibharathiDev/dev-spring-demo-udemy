package com.rmb.demo.demo.rest;

import com.rmb.demo.demo.entity.Students;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Students> theStudents = new ArrayList<>();

    @PostConstruct
    public void loadData()
    {
        theStudents.add(new Students("Manibharathi","Raveendran"));
        theStudents.add(new Students("Vimala","Manibharathi"));
        theStudents.add(new Students("Sainithran","Manibharathi"));
    }



    @GetMapping("/students")
    public List<Students> getStudentList()
    {
//        List<Students> studentsList = new ArrayList<>();
//        studentsList.add(new Students("Manibharathi","Raveendran"));
//        studentsList.add(new Students("Vimala","Manibharathi"));
//        studentsList.add(new Students("Sainithran","Manibharathi"));

        return theStudents;

    }

    @GetMapping("/students/{studentId}")
    public Students getStudentById(@PathVariable int studentId)
    {

//        if(studentId >= theStudents.size())
//        {
//            return new Students();
//        }



        if(studentId >= theStudents.size() || studentId < 0)
        {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe)
    {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(exe.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
    }

    // add another exception hanlder... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exe)
    {

        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(exe.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
