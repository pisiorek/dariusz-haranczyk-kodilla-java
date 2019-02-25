package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies(){
        //Given
        User john = new Millenials("johnny");
        User steven = new YGeneration("steve123");
        User adam = new ZGeneration("adam123");

        //When
        String johnShare = john.publisher();
        System.out.println("John publish: " + johnShare);
        String stevenShare = steven.publisher();
        System.out.println("Steven publish: " + stevenShare);
        String adamShare = adam.publisher();
        System.out.println("Adam publish: " + adamShare);

        //Then
        Assert.assertEquals("Facebook Publisher", johnShare);
        Assert.assertEquals("Twitter Publisher", stevenShare);
        Assert.assertEquals("Snapchat Publisher", adamShare);
    }

    @Test
    public void testIndividualSharingStrategy(){
        //Given
        User john = new Millenials("johnny");

        //When
        String johnShare = john.publisher();
        System.out.println("Steven publish: " + johnShare);
        john.setSocialPublisher(new TwitterPublisher());
        johnShare = john.publisher();
        System.out.println("Steven now should publish on: " + johnShare);

        //Then
        Assert.assertEquals("Twitter Publisher", johnShare);
    }
}
