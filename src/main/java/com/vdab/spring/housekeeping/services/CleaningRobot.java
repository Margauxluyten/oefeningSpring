package com.vdab.spring.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
@Lazy
@Qualifier("robot")
public class CleaningRobot implements CleaningService{

    @Autowired
    private List<CleaningTool>tools;

    public void setCleaningTools(List<CleaningTool> tools){
        this.tools = tools;
    }

    @Override
    public void clean() {
        System.out.println("cleaning the house with the robot");
        tools.forEach(CleaningTool::doCleanJob);
    }

    @PostConstruct
    public void init(){
        System.out.println("Cleaning robot preparing for work.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Cleaning robot cleaning up.");
    }
}
