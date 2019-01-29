package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers){

        IntStream.of(numbers)
                .mapToDouble(n->n)
                .forEach(System.out::println);

        return  IntStream.of(numbers)
                .mapToDouble(n->n)
                .average().getAsDouble();
    }
}


/*        IntStream.of(numbers)
                .mapToDouble(n->n)
                .forEach(System.out::println);*/

