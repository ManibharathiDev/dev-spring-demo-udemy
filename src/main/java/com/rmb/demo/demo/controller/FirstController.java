package com.rmb.demo.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    // inject properties for coach.name and coach.age
    @Value("${coach.name}")
    private String coachName;

    @Value("${coach.age}")
    private String coachAge;

    @GetMapping("/")
    public String helloWorld()
    {
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/name")
    public String getName()
    {
        return "<h2>Manibharathi</h2>";
    }

    // expose a new end point "workout"
    @GetMapping("/workout")
    public String getDailyWorkout()
    {
        return "Run a hard 5k!";
    }

    //expose a new end point for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune()
    {
        return "Today is your lucky day!";
    }

    @GetMapping("/coach_name")
    public String getCoachName()
    {
        return "Your coach name is "+coachName;
    }

    @GetMapping("/coach_age")
    public String getCoachAge()
    {
        return "Your coach age is "+coachAge;
    }


}
