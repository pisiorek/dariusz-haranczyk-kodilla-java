package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final int userID;
    private final String userName;
    private final  char userSex;
    private final LocalDate userBornDate;
    private final int postsNumber;

    public ForumUser(int userID, String userName, char userSex, LocalDate userBornDate, int postsNumber) {
        this.userID = userID;
        this.userName = userName;
        this.userSex = userSex;
        this.userBornDate = userBornDate;
        this.postsNumber = postsNumber;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getUserBornDate() {
        return userBornDate;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userBornDate=" + userBornDate +
                ", postsNumber=" + postsNumber +
                '}';
    }
}
