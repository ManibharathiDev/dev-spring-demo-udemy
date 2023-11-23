package com.rmb.demo.demo.rest;

import com.rmb.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    // define a private field for the dependency
    // Define a setter method for dependency injection
    // Field Injection
    @Autowired
    private Coach coach;

    // Define a setter method for dependency injection
    // Setter Injection
    @Autowired
    public void setCoach(Coach coach)
    {
        //this.coach = coach;
    }

    // Define a constructor for dependency injection
    // Constructor Injection

    @Autowired
    public CoachController(Coach coach)
    {
        //this.coach = coach;
    }


    @GetMapping("/daily-workout")
    public String getDailyWorkout()
    {
        return  coach.getDailyWorkOut();
    }

}
