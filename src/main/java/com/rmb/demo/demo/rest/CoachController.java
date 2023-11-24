package com.rmb.demo.demo.rest;

import com.rmb.demo.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {


    private Coach coach;

    // Setter Inject with @Qualifier Annotation
    @Autowired
    private void setCoach(@Qualifier("cricketCoach") Coach coach)
    {
        this.coach = coach;
    }

    //Constructor Inject with @Qualifier Annotation
    /*public CoachController(@Qualifier("tennisCoach") Coach coach)
    {
        this.coach = coach;
    }*/


    @GetMapping("/daily-workout")
    public String getDailyWorkout()
    {
        return  coach.getDailyWorkOut();
    }

}
