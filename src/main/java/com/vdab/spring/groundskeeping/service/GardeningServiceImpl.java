package com.vdab.spring.groundskeeping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
public class GardeningServiceImpl implements GardeningService {

    @Autowired
    private GardeningTool tool;


    public void setGardeningTool(GardeningTool tool){
        this.tool= tool;
        System.out.println("[gardeningServiceImpl] set gardening tool  ");
    }
    @PostConstruct
    public void init(){
        System.out.println("GardeningService preparing for work.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("GardeningService cleaning up.");
    }

    public void garden(){
        System.out.println("Working in the garden.");
        tool.doGardenJob();
    }

    }

