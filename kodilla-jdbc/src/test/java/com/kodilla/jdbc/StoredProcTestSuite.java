package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.Assert.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException{
        //Given
        DbManager dbManager = DbManager.getInstance();                      //nawiązanie połączenia z bazą
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";      //zapytanie ustwiające pola w tabeli READERS
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);                                 //wywołanie update - stsujemy dla aktualizacji danych bezpośredniow bazie

        //When
        String sqlProcedureCall = "CALL UpdateVipLevels()";                 //ustawienie procedury
        statement.execute(sqlProcedureCall);                                //wywołanie procedury

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if(rs.next()){
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0,howMany);
    }
}
