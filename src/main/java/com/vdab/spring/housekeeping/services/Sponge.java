package com.vdab.spring.housekeeping.services;

public class Sponge implements CleaningTool{
    @Override
    public void doCleanJob() {
        System.out.println("Splash splash");
    }
}
