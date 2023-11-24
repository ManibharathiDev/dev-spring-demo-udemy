package com.rmb.demo.demo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

    public BaseBallCoach()
    {
        System.out.println("In constructor "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {

        return "Spend 30 mins in batting practice";
    }
}
