package com.rmb.demo.demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach()
    {
        System.out.println("In constructor "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Spend 45 Mins in running practice";
    }
}
