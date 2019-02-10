package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {
    /**
    *generalnie w klasie main przechwytuje się try'em miejsce możliwości wystąpienia błedu
     * problematyczny kod obejmujemy klamrami a w sekcji catch wskazujemy jaki to może być wyjątek (nawiasy okrągłę)
     * oraz co zrobić w chwili jego wystąpienia (w nawiasach wąsatych). W sekcji finally wrzucamy kod który się wykona
     * niezależnie od tego czy błąd wsytąpi czy nie. Stosujemy np. żeby zapisać datę lub czas zaistnienia zdarzenia
     *
     * w tym przypadku jako exception wskazujemy utworzony przez MessageNotSentException
     */
    public static void main(String[] args) {
        User user = null;
        //User user = new User("Maciek");
        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println("Message is not send," +
                    "but my program still running very well!");
        }

        System.out.println("Processing other logic!");
    }
}
