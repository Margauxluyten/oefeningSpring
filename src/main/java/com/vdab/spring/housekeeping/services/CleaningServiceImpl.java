package com.vdab.spring.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class CleaningServiceImpl implements CleaningService{

    @Autowired
    @Qualifier(value = "sponge")
    private CleaningTool tool;

    private float rate;

    public void setCleaningTool(CleaningTool tool){
        this.tool = tool;
    }
    @Value("9")
    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public void clean() {
        System.out.println("Cleaning the house");
        tool.doCleanJob();
    }

    @PostConstruct
    public void init(){
        System.out.println("Cleaning service preparing for work.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Cleaning service cleaning up.");
    }
}
