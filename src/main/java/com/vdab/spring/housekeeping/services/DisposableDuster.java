package com.vdab.spring.housekeeping.services;

import org.springframework.stereotype.Service;

@Service
public class DisposableDuster implements CleaningTool{
    private boolean used = false;
    @Override
    public void doCleanJob() {
        if (used){
            System.out.println("I'm already used. Please throw me away!");
        }else{
            System.out.println("Wipe the dust away");
            used= true;
        }
    }
}
