package com.kodilla.testing.forum.statistics;

import java.util.List;

public interface Statistics {
    /**
     @returns list of users names
     */
    List<String> usersNames();
    /**
     @returns total quantity of forum posts
     */
    int postsCount();
    /**
     @returns total quantity of forum comments
     */
    int commentsCount();
}