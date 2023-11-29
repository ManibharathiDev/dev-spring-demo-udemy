package com.rmb.demo.demo.rest;

import com.rmb.demo.demo.entity.Students;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        if(studentId >= theStudents.size())
        {
            return new Students();
        }

        return theStudents.get(studentId);
    }

}