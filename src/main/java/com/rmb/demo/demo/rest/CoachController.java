package com.rmb.demo.demo.rest;

import com.rmb.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    // define a private field for the dependency
    private Coach coach;

    // Define a constructor for dependency injection
    @Autowired
    public CoachController(Coach coach)
    {
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return  coach.getDailyWorkOut();
    }

}
