package com.kodilla.jdbc;

import com.kodilla.jdbc.DbManager;
import org.junit.Assert;
import org.junit.Test;
import java.sql.SQLException;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }
}
