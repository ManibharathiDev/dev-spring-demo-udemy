package com.rmb.demo.demo.config;

import com.rmb.demo.demo.common.Coach;
import com.rmb.demo.demo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoachConfig {
    //In Default method name is bean ID
    //If you want to change bean ID mention in the @Bean annotation
    @Bean("aqua")
    public Coach swimCoach()
    {
        return new SwimCoach();
    }
}
