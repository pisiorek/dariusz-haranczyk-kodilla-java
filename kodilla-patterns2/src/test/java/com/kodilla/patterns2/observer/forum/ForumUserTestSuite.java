package com.kodilla.patterns2.observer.forum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {
    @Test
    public void testUpdate(){
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();

        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
        ForumUser kubaKot = new ForumUser("Jakub Kot");

        javaHelpForum.registerObserver(johnSmith);
        javaHelpForum.registerObserver(kubaKot);

        javaToolsForum.registerObserver(kubaKot);
        javaToolsForum.registerObserver(ivoneEscobar);

        //When
        javaHelpForum.addPost("Cześć wszystkim");
        javaHelpForum.addPost("Najlepiej zrobić to inaczej");
        javaHelpForum.addPost("Lorem Ipsum ....");

        javaToolsForum.addPost("Tamto rozwiązanie jest lepsze");
        javaToolsForum.addPost("Przykładowy post");

        //Then
/*        int size = javaHelpForum.getMessages().size();
        int size1 = javaToolsForum.getMessages().size();
        System.out.println(size);
        System.out.println(size1);*/
        assertEquals(3, johnSmith.getUpdateCount());
        assertEquals(2, ivoneEscobar.getUpdateCount());
        assertEquals(5, kubaKot.getUpdateCount());

    }
}
