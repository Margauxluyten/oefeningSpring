package com.vdab.spring.master;

import com.vdab.spring.groundskeeping.service.GardeningService;
import com.vdab.spring.housekeeping.services.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Service("domesticService")
public class DomesticServiceImp implements DomesticService{

    @Autowired
    @Qualifier(value = "robot")
    private CleaningService cleaningService;

    @Autowired
//    @Qualifier(value = "steve")
    private GardeningService gardeningService;

    @Autowired
    private Logger logger;

    @Override
    public void runHouseHold() {
        logger.info("Running the household, making everybody happy! ");
        cleaningService.clean();
        gardeningService.garden();

    }

    public void setCleaningService(CleaningService cleaningService){
        this.cleaningService = cleaningService;
    }

    public void setGardeningService(GardeningService gardeningService){
        this.gardeningService = gardeningService;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @PostConstruct
    public void init(){
        System.out.println("Domestic service preparing for work.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Domestic service cleaning up.");
    }
}
