package com.vdab.spring.groundskeeping.service;

public class LawnMower implements GardeningTool {

    @Override
    public void doGardenJob() {
        System.out.println("Mowing the lawn!");

    }
}
