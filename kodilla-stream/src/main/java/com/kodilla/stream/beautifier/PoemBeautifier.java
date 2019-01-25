package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify (String a,String b, PoemDecorator poemDecorator){

        String temp = poemDecorator.decorate(a, b);
        System.out.println(temp);

    }
}
