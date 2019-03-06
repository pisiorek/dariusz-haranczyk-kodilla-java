package com.kodilla.exception.nullpointer;
/***
* ta klasa tworzy własny wyjątek który możemy obsłużyć i użyć w innych klasach
* */
public class MessageNotSentException extends Exception {

    public MessageNotSentException(final String message){
        super(message);
    }
}
