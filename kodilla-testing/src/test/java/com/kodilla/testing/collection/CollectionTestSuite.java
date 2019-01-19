package com.kodilla.testing.collection;

//import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Test case Start");
    }
    @After
    public void after(){
        System.out.println("Test case Stop");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){

        //Given
        ArrayList<Integer> numbers = new ArrayList<>(); //utworzenie listy do przekazania w argumencie do obiektu OddNumbersEx..

        OddNumbersExterminator listOddNumbers = new OddNumbersExterminator();

        //When
            //przekazanie pustej listy utworzonej jako argumentu do metody exterminate i odebranie rezultatu metody exterminate
        ArrayList<Integer> resultList = listOddNumbers.exterminate(numbers);
        System.out.println("Trwa testowanie pustej listy");

        //Then
        Assert.assertTrue(resultList.isEmpty());
    }

/*    @Before
    public void beforeNormalList(){
        System.out.println("Test poprawności listy Start");
    }
    @After
    public void afterNormalList(){
        System.out.println("Test poprawności listy Stop");
    }*/

    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer> numbers = new ArrayList<>(); //utworzenie listy do przekazania w argumencie do obiektu OddNumbersEx..

        //dodanie wartosci do listy
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(11);
        numbers.add(14);
        numbers.add(16);

        //utworzenie obiektu OddNumbersExterminator
        OddNumbersExterminator listOddNumbers = new OddNumbersExterminator();

        //When
            //przekazanie listy utworzonej jako argumentu do metody exterminate i odebranie przefiltrowanej listy
        ArrayList<Integer> resultList = listOddNumbers.exterminate(numbers);

        System.out.println("Testowanie przypadku poprawnie wypełnionej listy");

        //Then
        Assert.assertTrue(resultList.size() == 5);
        for(Integer listElement: resultList) {
            Assert.assertTrue((listElement % 2)==0 );
        }


    }


}
