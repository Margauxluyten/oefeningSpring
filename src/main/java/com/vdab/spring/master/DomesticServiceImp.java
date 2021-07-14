package com.vdab.spring.master;

import com.vdab.spring.groundskeeping.service.GardeningService;
import com.vdab.spring.housekeeping.services.CleaningService;

public class DomesticServiceImp implements DomesticService{

    private CleaningService cleaningService;

    private GardeningService gardeningService;

    @Override
    public void runHouseHold() {
        cleaningService.clean();
        gardeningService.garden();
    }

    public void setCleaningService(CleaningService cleaningService){
        this.cleaningService = cleaningService;
    }

    public void setGardeningService(GardeningService gardeningService){
        this.gardeningService = gardeningService;
    }
}
