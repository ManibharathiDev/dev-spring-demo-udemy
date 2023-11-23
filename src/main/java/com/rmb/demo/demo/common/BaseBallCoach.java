package com.rmb.demo.demo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Spend 30 mins in batting practice";
    }
}
