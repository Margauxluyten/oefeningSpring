package com.vdab.spring.housekeeping.services;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
@Order(3)
@Profile("smallHouse")
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
