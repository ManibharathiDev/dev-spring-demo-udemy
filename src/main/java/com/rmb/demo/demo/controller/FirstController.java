package com.rmb.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

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


}
