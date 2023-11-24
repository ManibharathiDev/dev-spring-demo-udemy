package com.rmb.demo.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    // Define Init Method
    @PostConstruct
    public void doMyStartupStuff()
    {
        System.out.println("In do my startup stuff "+getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStuff()
    {
        System.out.println("In do my clean up stuff "+getClass().getSimpleName());
    }

    public TrackCoach()
    {
        System.out.println("In constructor "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Spend 15 mins in Yoga";
    }


}
