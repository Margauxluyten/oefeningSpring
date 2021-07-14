package com.vdab.spring;

import com.vdab.spring.AppConfig;
import com.vdab.spring.housekeeping.services.*;
import com.vdab.spring.master.DomesticService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp {
    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Container initialized");
        DomesticService service = ctx.getBean("domesticService", DomesticService.class);
        service.runHouseHold();



//        CleaningService jill = ctx.getBean("valerie", CleaningService.class);
//        CleaningService bob = ctx.getBean("john", CleaningService.class);
//        CleaningService jane = ctx.getBean("liz", CleaningService.class);
//        CleaningService scott = ctx.getBean("scott", CleaningService.class);



//        CleaningTool broom = new Broom();
//        CleaningTool vacuum = new VacuumCleaner();
//        CleaningTool sponge = new Sponge();
//
//        CleaningServiceImpl jill = new CleaningServiceImpl();
//        jill.setCleaningTool(broom);
//        CleaningServiceImpl bob = new CleaningServiceImpl();
//        bob.setCleaningTool(vacuum);
//        CleaningServiceImpl jane = new CleaningServiceImpl();
//        jane.setCleaningTool(sponge);

//        jill.clean();
//        bob.clean();
//        jane.clean();
//        scott.clean();
//        scott.clean();  // dirty duster
//        ctx.close();

    }
}
