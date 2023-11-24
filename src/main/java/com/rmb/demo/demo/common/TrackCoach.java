package com.rmb.demo.demo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach implements Coach{

    public TrackCoach()
    {
        System.out.println("In constructor "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Spend 15 mins in Yoga";
    }
}
