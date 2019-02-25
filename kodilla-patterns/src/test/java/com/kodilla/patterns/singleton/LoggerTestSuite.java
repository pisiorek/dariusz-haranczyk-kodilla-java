package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    @BeforeClass
    public static void createLogger(){
        Logger.getInstance();
    }

    @Test
    public void testGetLog() {
        //Given

        //When
        Logger.getInstance().log("Log number 1");
        String log = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals("Log number 1", log);
    }
}
