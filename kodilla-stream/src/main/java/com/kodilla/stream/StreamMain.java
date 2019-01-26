package com.kodilla.stream;

//import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    private static Object ExecuteSaySomething;

    public static void main(String[] args) {


/*      Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);*/

        Processor processor = new Processor();
        //tworzymy stream, typ streama musi być taki ja interfejs którego metody wykorzystuje
        //Executor codeToExecute = () -> System.out.println("This is an example text.");
        //processor.execute(codeToExecute);
        //bezpośrednie przekazanie argumentu do metody bez tworzenie obiektu executor
        processor.execute(() -> System.out.println("Przykładowy tekst"));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("Upiększacz tekstu");
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Piękny tekst","ABC",(a,b) -> a+b);
        poemBeautifier.beautify("KKKK + ","InnyTekst",(a,b) -> a+b);
        poemBeautifier.beautify("małe literki na ", "wielkie",(a, b) -> a + b.toUpperCase());
        poemBeautifier.beautify("aaaaaa", "bbbbb",(a, b) -> a + b.concat("cccccccc"));
        poemBeautifier.beautify("aaaaaa", "bbbb",(a, b) -> a + b + b + "ABBBCCC" + " +-" + 987654321);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);





    }
}
