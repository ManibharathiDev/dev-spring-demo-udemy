package com.rmb.demo.demo.rest;

import com.rmb.demo.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {


    private Coach coach;
    private Coach anotherCoach;

    public CoachController(@Qualifier("trackCoach") Coach coach)
    {
        this.coach = coach;

    }


    /*@Autowired
    public CoachController(@Qualifier("cricketCoach") Coach coach, @Qualifier("cricketCoach") Coach anotherCoach)
    {
        this.coach = coach;
        this.anotherCoach = anotherCoach;

        System.out.println("Coach Status => "+(this.coach == this.anotherCoach));
    }*/

    @GetMapping("/check")
    public String check()
    {
        return "Status => "+(this.coach == this.anotherCoach) +" ";
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout()
    {
        return  coach.getDailyWorkOut();
    }

}
