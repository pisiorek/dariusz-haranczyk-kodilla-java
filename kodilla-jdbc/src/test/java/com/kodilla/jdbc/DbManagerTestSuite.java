package com.kodilla.jdbc;

import com.kodilla.jdbc.DbManager;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER\n" +
                "FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID\n" +
                "GROUP BY P.USER_ID\n";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getInt("POSTS_NUMBER"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(3, counter);

        System.out.println("\n");
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER\n" +
                "FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID\n" +
                "GROUP BY P.USER_ID\n" +
                "HAVING COUNT(*) >= 2";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;

        System.out.println("Users with posts quantity larger than 2: \n");

        while(rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + " - posts number in DataBase: " +
                    rs.getInt("POSTS_NUMBER"));

            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(2, counter);

    }
}
