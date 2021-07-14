package com.vdab.spring;

import com.vdab.spring.groundskeeping.service.GardeningService;
import com.vdab.spring.groundskeeping.service.GardeningServiceImpl;
import com.vdab.spring.groundskeeping.service.GardeningTool;
import com.vdab.spring.groundskeeping.service.LawnMower;
import com.vdab.spring.housekeeping.services.*;
import com.vdab.spring.master.DomesticService;
import com.vdab.spring.master.DomesticServiceImp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class AppConfig {
  // factory method
    @Bean
    @Scope(value = "prototype")
    @Primary
    public CleaningTool broom(){
        System.out.println("New broom created");
        return new Broom();
    }

    @Bean
    @Scope(value = "prototype")
    public CleaningTool vacuum(){
        System.out.println("New vacuum cleaner created");
        return new VacuumCleaner();
    }
    @Bean
    @Scope(value = "prototype")
    @Qualifier(value = "wet")
    public CleaningTool sponge(){
        System.out.println("New sponge created");
        return new Sponge();
    }

    @Bean
    @Scope(value = "prototype",proxyMode = ScopedProxyMode.INTERFACES)  // nieuwe instantie (gooit de oude duster weg)
    public CleaningTool duster(){
        return new DisposableDuster();
    }
    @Bean
    @Primary
    public GardeningTool lawnMower(){
        return new LawnMower();
    }

    @Bean(name = "valerie")
    @Lazy
    @Primary
    public CleaningService jill(CleaningTool tool){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(tool);
        System.out.println("She is now cleaning your house");
        return cs;
    }
    @Bean(name = "john")
    @Lazy
    public CleaningService bob(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(vacuum());
        System.out.println("He is now cleaning your house");
        return cs;
    }
    @Bean(name = "liz")
    @Lazy
    public CleaningService jane(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(sponge());
        System.out.println("She is now cleaning your house");
        return cs;
    }
    @Bean
    public CleaningService scott(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(duster());
        return cs;
    }
    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Primary
    public GardeningService ben(GardeningTool tool){
        GardeningServiceImpl gs = new GardeningServiceImpl();
        gs.setGardeningTool(tool);
        return gs;
    }
    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Primary
    public GardeningService steve(){
        GardeningServiceImpl gs = new GardeningServiceImpl();
        gs.setGardeningTool(lawnMower());
        return gs;
    }
    @Bean
    public DomesticService domesticService(){
        DomesticServiceImp ds = new DomesticServiceImp();
        ds.setCleaningService(scott());
        ds.setGardeningService(steve());
        System.out.println("cleaning and garden set ");
        return ds;
    }

//    @Bean
//    public DomesticService domesticService(GardeningService gs,CleaningService cs){
//        DomesticServiceImp ds = new DomesticServiceImp();
//        ds.setCleaningService(cs);
//        ds.setGardeningService(gs);
//        return ds;
//    }

}
