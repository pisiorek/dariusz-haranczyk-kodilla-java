package com.kodilla.stream.forumuser;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> forumUsersList = new ArrayList<>();

    public Forum (){
        forumUsersList.add(new ForumUser(1,"Rafał", 'M', LocalDate.of(1979,6,1),25));
        forumUsersList.add(new ForumUser(2, "Kamil",'M', LocalDate.of(1988,8,14), 0) );
        forumUsersList.add(new ForumUser(3, "Ala",'F', LocalDate.of(1948,8,15), 430) );
        forumUsersList.add(new ForumUser(4, "Agata",'F', LocalDate.of(1984,5,14), 50) );
        forumUsersList.add(new ForumUser(5, "Ala",'F', LocalDate.of(1976,1,2), 4) );
        forumUsersList.add(new ForumUser(6, "Anna",'F', LocalDate.of(1966,2,23), 5) );
        forumUsersList.add(new ForumUser(7, "Zbyszek",'M', LocalDate.of(1977,4,11), 66) );
        forumUsersList.add(new ForumUser(8, "Ewa",'F', LocalDate.of(2000,1,2), 10) );
        forumUsersList.add(new ForumUser(9, "Daniel",'M', LocalDate.of(2001,2,23), 5) );
        forumUsersList.add(new ForumUser(10, "Marta",'F', LocalDate.of(1975,4,11), 0) );
    }

    public List<ForumUser> getList(){
        return new ArrayList<>(forumUsersList);
    }
}
