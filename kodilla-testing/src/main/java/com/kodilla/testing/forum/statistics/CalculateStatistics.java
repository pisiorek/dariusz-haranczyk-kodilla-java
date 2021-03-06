package com.kodilla.testing.forum.statistics;

public class CalculateStatistics {

    //Statistics statistics;
    private  int usersNumber = 0;
    private  int postsNumber = 0;
    private  int commentsNumber = 0;
    private  double averagePostPerUser = 0;
    private  double averageCommentsPerUser = 0;
    private  double averageCommentsPerPost = 0;

    public int getUsersNumber() {
        return usersNumber;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public double getAveragePostPerUser() {
        return averagePostPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }

    public double calculateAdvStatistics(Statistics statistics){

         //wywołujemy metodę postsCount zadeklarowaną w interfejsie i zwrócone przez nią
        //dane w postaci liczby postów zapisujemy w polu postsNumber
        this.postsNumber = statistics.postsCount();

        //za pomoca metody commentsCount uzyskujemy ilość komentarzy i zapisujemy do pola commentsNumber
        this.commentsNumber= statistics.commentsCount();

        //wyliczamy wymagane średnie
        this.averagePostPerUser = (double)postsNumber / (double)usersNumber;
        this.averageCommentsPerUser = (double)commentsNumber / (double)usersNumber;
        this.averageCommentsPerPost = (double)commentsNumber / (double)postsNumber;

        return usersNumber = statistics.usersNames().size();
    }

    //metoda wyświetlająca statystyki
    public void showStatistics(){

        System.out.println("Liczba użytkowników " + getUsersNumber() + "\n Liczba postów " + getPostsNumber()
                + "\n Liczba komentarzy " + getCommentsNumber() + "\n Srednia komentarz/user " + getAverageCommentsPerUser()
                + "\n Srednia komentarz/post " + getAverageCommentsPerPost() + "\n Srednia post/user " + getAveragePostPerUser());
    }
}
