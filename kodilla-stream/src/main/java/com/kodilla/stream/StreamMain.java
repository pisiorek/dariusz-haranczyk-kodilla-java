package com.kodilla.stream;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        /************************Część I - filtrowanie po płci, wieku i ilości postów********************************
         *         Podzieliłem to zadanie na dwie części bo nie było w treści doprecyzowane, czy wykonać wszystkie filtrowania od początku do
         *             końca, i wyswietlić wynik, czy każde filtrowanie robić z osobna z osobnym wynikiem */
        Forum forum = new Forum();
        List<ForumUser> forumUsersList = forum.getList().stream()
                .filter(forumUser -> forumUser.getUserSex() =='M')          //filtrujemy mężczyzn
                .filter(forumUser -> LocalDate.now().getYear() - forumUser.getUserBornDate().getYear() > 20)        //filtrujemy starszych niż 20 lat
                .filter(forumUser -> forumUser.getPostsNumber() > 0)        //filtrujemy tych którzy mają przynajmniej 1 post
                .collect(Collectors.toList());

        System.out.println("# elements: " + forumUsersList.size());
        forumUsersList.stream()
                .forEach(System.out::println);

        /********************Część II zadania - utworzenie mapy z userami**************************************************/


        Map <Integer,ForumUser> mapUsers = forum.getList().stream()
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        System.out.println("# elements: " + mapUsers.size());
        mapUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
