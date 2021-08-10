package com.vdab.spring.housekeeping.services;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Profile("smallHouse")
public class Broom implements CleaningTool{


    @Override
    public void doCleanJob() {
        System.out.println("Scrub scrub");

    }

}
