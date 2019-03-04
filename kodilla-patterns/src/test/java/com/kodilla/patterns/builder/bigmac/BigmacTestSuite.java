package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .burgers(2)
                .bun("With sesame")
                .sauce("Barbecue")
                .ingredient("Onion")
                .ingredient("Chilli")
                .ingredient("Becon")
                .ingredient("Mushrooms")
                .ingredient("Lettuce")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(5, howManyIngredients);
    }
}
