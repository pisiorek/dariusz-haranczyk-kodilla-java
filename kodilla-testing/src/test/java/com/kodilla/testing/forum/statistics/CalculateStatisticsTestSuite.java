package com.kodilla.testing.forum.statistics;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateStatisticsTestSuite {
    static  int counter = 0;
    @Before
    public void showTestCounter(){
        counter++;
        System.out.println(counter);
    }

    @Test
    public void testCalculateNumbersOfUsers() {
        //Given

        //tworzymy obiekt symulujący obiekt klasy implementującej interfejs Statistics
        Statistics statisticsMock = mock(Statistics.class);
        //przygotowanie danych symulacyjnych dla klasy CalculateStatistics, czyli liczba postów i komentarzy
        //oraz ArrayListy z imionami uzytkowników
        int postsNumber = 10;
        int commentsNumber = 50;
        List<String> namesList = new ArrayList<String>();
        namesList.add("Darek");
        namesList.add("Jarek");
        namesList.add("Arek");
        namesList.add("Mateusz");
        namesList.add("Wojtek");

        //kiedy dla instancji obiektu symulującego (mockito)zostanie wywołana matoda wymagana przez interfejs Statistics
        //wtedy zwróć dane symulowane - w tym wypadku namesList zadeklarowaną w interfejsie
        when(statisticsMock.usersNames()).thenReturn(namesList);
        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);
        when(statisticsMock.postsCount()).thenReturn(postsNumber);

        //utworzenie obiektu calculate, bez argumentów
        CalculateStatistics calculateStats = new CalculateStatistics();

        //When

        //wywołanie metody głównej metody klasy C..S.. która w konstruktorze przyjmuje
        //obiekt symulujący interfejs Statistics
        double userNumber = calculateStats.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertTrue(5 == userNumber);
        System.out.println("Statystyki dla testu głównego: \n");
        calculateStats.showStatistics();
    }

    @Test
    public void testForZeroPost() {
        //Given

        //tworzymy obiekt symulujący obiekt klasy implementującej interfejs Statistics
        Statistics statisticsMock = mock(Statistics.class);
        //przygotowanie danych symulacyjnych dla klasy CalculateStatistics czyli liczba postów i komentarzy
        //oraz ArrayListy z imionami uzytkowników
        int postsNumber = 0;

        //wskazujemy mockowi jakie dane ma zwrócić po wywołaniu określonych metod

        when(statisticsMock.postsCount()).thenReturn(postsNumber);

        CalculateStatistics calculateStats = new CalculateStatistics();

        //When

        //przekazanie obiektu mocka w argumencie metody calculateAdvStatistics
        //w tym wypadku konieczne aby nastąpiły obliczenia oraz ustawienie pól klasy C..S..
        calculateStats.calculateAdvStatistics(statisticsMock);
        double howManyPosts = calculateStats.getPostsNumber();

        //Then
        Assert.assertTrue(0 == howManyPosts);


    }
    @Test
    public void testFor1000Posts() {
        //Given

        //tworzymy obiekt symulujący obiekt klasy implementującej interfejs Statistics
        Statistics statisticsMock = mock(Statistics.class);
        //przygotowanie danych symulacyjnych dla klasy CalculateStatistics czyli liczba postów i komentarzy
        //oraz ArrayListy z imionami uzytkowników
        int postsNumber = 1000;

        //wskazujemy mockowi jakie dane ma zwrócić po wywołaniu określonych metod

        when(statisticsMock.postsCount()).thenReturn(postsNumber);

        CalculateStatistics calculateStats = new CalculateStatistics();

        //When
        calculateStats.calculateAdvStatistics(statisticsMock);
        double postNumber = calculateStats.getPostsNumber();

        //Then
        Assert.assertTrue(1000 == postNumber);


    }
    @Test
    public void testForZeroComments() {
        //Given

        //tworzymy obiekt symulujący obiekt klasy implementującej interfejs Statistics
        Statistics statisticsMock = mock(Statistics.class);
        //przygotowanie danych symulacyjnych dla klasy CalculateStatistics czyli liczba postów i komentarzy
        //oraz ArrayListy z imionami uzytkowników

        int commentsNumber = 0;


        //wskazujemy mockowi jakie dane ma zwrócić po wywołaniu określonych metod

        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);

        CalculateStatistics calculateStats = new CalculateStatistics();

        //When
        calculateStats.calculateAdvStatistics(statisticsMock);
        double commentsNum = calculateStats.getCommentsNumber();


        //Then
        Assert.assertTrue(0 == commentsNum);


    }
    @Test
    public void testForMorePost() {
        //Given

        //tworzymy obiekt symulujący obiekt klasy implementującej interfejs Statistics
        Statistics statisticsMock = mock(Statistics.class);
        //przygotowanie danych symulacyjnych dla klasy CalculateStatistics czyli liczba postów i komentarzy
        //oraz ArrayListy z imionami uzytkowników

        int postsNumber = 100;
        int commentsNumber = 50;

        //wskazujemy mockowi jakie dane ma zwrócić po wywołaniu określonych metod

        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);
        when(statisticsMock.postsCount()).thenReturn(postsNumber);

        CalculateStatistics calculateStats = new CalculateStatistics();

        //When
        calculateStats.calculateAdvStatistics(statisticsMock);
        double commentsNum = calculateStats.getCommentsNumber();
        double postsNum = calculateStats.getPostsNumber();

        //Then
        Assert.assertTrue(postsNum > commentsNum);


    }

    @Test
    public void testForMoreComments() {
        //Given

        //tworzymy obiekt symulujący obiekt klasy implementującej interfejs Statistics
        Statistics statisticsMock = mock(Statistics.class);
        //przygotowanie danych symulacyjnych dla klasy CalculateStatistics czyli liczba postów i komentarzy
        //oraz ArrayListy z imionami uzytkowników

        int postsNumber = 20;
        int commentsNumber = 50;

        //wskazujemy mockowi jakie dane ma zwrócić po wywołaniu określonych metod

        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);
        when(statisticsMock.postsCount()).thenReturn(postsNumber);

        CalculateStatistics calculateStats = new CalculateStatistics();

        //When
        calculateStats.calculateAdvStatistics(statisticsMock);
        double commentsNum = calculateStats.getCommentsNumber();
        double postsNum = calculateStats.getPostsNumber();

        //Then
        Assert.assertTrue(postsNum < commentsNum);


    }
    @Test
    public void testForEmptyList() {
        //Given

        //tworzymy obiekt symulujący obiekt klasy implementującej interfejs Statistics
        Statistics statisticsMock = mock(Statistics.class);
        //przygotowanie danych symulacyjnych dla klasy CalculateStatistics, czyli liczba postów i komentarzy
        //oraz ArrayListy z imionami uzytkowników

        List<String> namesList = new ArrayList<String>();


        //kiedy dla instancji obiektu symulującego (mockito)zostanie wywołana matoda wymagana przez interfejs Statistics
        //wtedy zwróć dane symulowane - w tym wypadku namesList zadeklarowaną w interfejsie
        when(statisticsMock.usersNames()).thenReturn(namesList);

        //utworzenie obiektu calculate, bez argumentów
        CalculateStatistics calculateStats = new CalculateStatistics();

        //When

        //wywołanie metody głównej metody klasy C..S.. która w konstruktorze przyjmuje
        //obiekt symulujący interfejs Statistics
        double userNumber = calculateStats.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertTrue(0 == userNumber);


    }
    @Test
    public void testForHundredElements() {
        //Given

        //tworzymy obiekt symulujący obiekt klasy implementującej interfejs Statistics
        Statistics statisticsMock = mock(Statistics.class);
        //przygotowanie danych symulacyjnych dla klasy CalculateStatistics, czyli liczba postów i komentarzy
        //oraz ArrayListy z imionami uzytkowników

        List<String> namesList = new ArrayList<String>();
        Random generator = new Random();
        String addLetters ="";
        //generujemy automatycznie listę
        for (int i=0; i < 100;i++){
            for(int j = 0; j < generator.nextInt(20); j++ ){
                addLetters += "a";
            }
            namesList.add(addLetters);
            addLetters = "";

        }



        //kiedy dla instancji obiektu symulującego (mockito)zostanie wywołana matoda wymagana przez interfejs Statistics
        //wtedy zwróć dane symulowane - w tym wypadku namesList zadeklarowaną w interfejsie
        when(statisticsMock.usersNames()).thenReturn(namesList);

        //utworzenie obiektu calculate, bez argumentów
        CalculateStatistics calculateStats = new CalculateStatistics();

        //When
        //wywołanie metody głównej metody klasy C..S.. która w konstruktorze przyjmuje
        //obiekt symulujący interfejs Statistics
        double userNumber = calculateStats.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertTrue(100 == userNumber);

    }

}
