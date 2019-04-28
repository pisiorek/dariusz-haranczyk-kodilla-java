package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class WatcherTaxiOrder {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.kodilla.patterns2.facade.api.WatcherTaxiOrder.class);

/*    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEvent(){
        LOGGER.info("Logging by Watcher ");
    }*/

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order) && args(userId) && target(object)")
    public void logEvent(OrderDto order, Long userId, Object object){
        LOGGER.info("Class: " + object.getClass().getName() + ", Args " + order + ", Args " + userId);
    }
}
