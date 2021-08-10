package com.vdab.spring.groundskeeping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Scope(value = "prototype")
@Profile("bigHouse")
public class HedgeTrimmerFactory {

    @Bean
    @Primary
    public GardeningTool HedgeTrimmer(){
        int hour = LocalTime.now().getHour();
        if(hour > 8 && hour < 18){
            return () -> System.out.println("Trimming electric, we can make noise");
        }else{
            return () -> System.out.println("Trimming manual, no noise");
        }
    }

}
