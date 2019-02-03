package com.kodilla.exception.nullpointer;
/**
 * w tym miejscu obsługujemy wyjątek za pomocą throws plus nazwa klasy która ma obsłużyć wyjątek, w tym
 * przypadku jest to throws MessageNotSentException. W przypadku gdy ma dojść do wyjątku wówczas musimy stworzyć obiekt
 * throw new MessageNotSentException("Object User was null"); który sformatuje wiadomość która ma się pojawic w
 * wyświetlonym błędie
 * */
public class MessageSender {
    public void sendMessageTo(User user, String message)  throws MessageNotSentException{
        if(user != null) {
            System.out.println("Sending message: " + message + " to: " + user.getName());
        }else{
            throw new MessageNotSentException("Object User was null");

        }
    }
}