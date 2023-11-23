package com.rmb.demo.demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Spend 45 Mins in running practice";
    }
}
