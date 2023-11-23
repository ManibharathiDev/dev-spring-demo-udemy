package com.rmb.demo.demo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Spend 15 mins in Yoga";
    }
}
