package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithMock() {
        //Given

        //utworzenie obiektu mockito symulującego rzeczywisty obiekt, który będzie tworzony w przyszłości przez klasę
        // implementującą interfejs Temperatures
        //pozwala na dostęp do metod wymaganych przez interfejs Temperatures
        Temperatures temperaturesMock = mock(Temperatures.class);

        //poniżej tworzymy dane symulacyjne które mock przekaże dalej do
        //hashMapa "udająca" dane przekazane przez nie napisaną jeszcze klasę implementującą interfejs Temperatures
        HashMap<Integer, Double> temperaturesMap = new HashMap<Integer, Double>();
        temperaturesMap.put(0, 25.5);
        temperaturesMap.put(1, 26.2);
        temperaturesMap.put(2, 24.8);
        temperaturesMap.put(3, 25.2);
        temperaturesMap.put(4, 26.1);

        //kiedy na obiekcie symulującym (mockito)zostanie wywołana matoda wymagana przez interfejs Temperatures
        //wtedy zwróć dane symulowane - w tym wypadku hashMapę temperaturesMap zadeklarowaną w interfejsie
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //utworzenie obiektu i przekazanie mu w konstruktorze sztucznego interfejsu mocka
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When

        //wywołanie metody już na właściwym obiekcie do któego przekazaliśmy dane symulowane
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assert.assertEquals(5, quantityOfSensors);
    }
}