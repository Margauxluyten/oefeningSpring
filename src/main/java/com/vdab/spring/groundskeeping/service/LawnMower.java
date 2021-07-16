package com.vdab.spring.groundskeeping.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope("prototype")
public class LawnMower implements GardeningTool {

    @Override
    public void doGardenJob() {
        System.out.println("Mowing the lawn!");

    }
}
