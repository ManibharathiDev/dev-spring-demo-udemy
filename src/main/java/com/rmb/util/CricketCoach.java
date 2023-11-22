package com.rmb.util;

import org.springframework.stereotype.Component;
/*Add component annotation*/
@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling for 15 mins!";
    }
}
