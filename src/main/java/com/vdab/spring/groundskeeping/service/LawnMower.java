package com.vdab.spring.groundskeeping.service;

import org.springframework.stereotype.Service;


public class LawnMower implements GardeningTool {

    @Override
    public void doGardenJob() {
        System.out.println("Mowing the lawn!");

    }
}
