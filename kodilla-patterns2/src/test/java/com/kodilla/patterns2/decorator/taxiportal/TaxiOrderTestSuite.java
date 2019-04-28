package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;
import static org.junit.Assert.*;

public class TaxiOrderTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost(){
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();

        //When
        BigDecimal calculatedCost = taxiOrder.getCost();

        //Then
        assertEquals(new BigDecimal(5), calculatedCost);
    }
    @Test
    public void testBasicTaxiOrderGetDescription(){
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();

        //When
        String description = taxiOrder.getDescription();

        //Then
        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost(){
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();  //tworzymy delegata (obiekt bazowej klasy)
        theOrder = new TaxiNetworkOrderDecorator(theOrder); //tworzymy dekorator i przekazujemy mu delegata w konstruktorze

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(40), theCost);
    }

    @Test
    public void testTaxiNetworkGetDescription(){
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        //When
        String description  = theOrder.getDescription();

        //Then
        assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost(){
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder); // dodajemy fotelik dla dziecka
        taxiOrder = new ChildSeatDecorator(taxiOrder); // dodajemy kolejny fotelik dla dziecka - kaskada

        //When
        BigDecimal theCost = taxiOrder.getCost();

        //Then
        assertEquals(new BigDecimal(39), theCost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription(){
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);

        //When
        String description = taxiOrder.getDescription();

        //Then
        assertEquals("Drive a course by MyTaxi Network + child seat + child seat", description);

    }

    @Test
    public void testMyTaxiWithChildSeatExpressVipGetCost(){
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder); // dodajemy fotelik dla dziecka
        taxiOrder = new ChildSeatDecorator(taxiOrder); // dodajemy kolejny fotelik dla dziecka - kaskada
        taxiOrder = new ExpressDecorator(taxiOrder); //dodajemy usługę Express
        taxiOrder = new VipDecorator(taxiOrder); //dodajemy usługę VIP

        //When
        BigDecimal theCost = taxiOrder.getCost();

        //Then
        assertEquals(new BigDecimal(54), theCost);
    }

    @Test
    public void testMyTaxiWithChildSeatExpressVipGetDescription(){
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        taxiOrder = new ExpressDecorator(taxiOrder); //dodajemy usługę Express
        taxiOrder = new VipDecorator(taxiOrder); //dodajemy usługę VIP

        //When
        String description = taxiOrder.getDescription();

        //Then
        assertEquals("Drive a course by MyTaxi Network + child seat + child seat + express service + variant VIP", description);

    }
}
