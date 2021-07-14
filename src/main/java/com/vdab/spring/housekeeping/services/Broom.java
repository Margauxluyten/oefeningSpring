package com.vdab.spring.housekeeping.services;

public class Broom implements CleaningTool{


    @Override
    public void doCleanJob() {
        System.out.println("Scrub scrub");

    }

}
