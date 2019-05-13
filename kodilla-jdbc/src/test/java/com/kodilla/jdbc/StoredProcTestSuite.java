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
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";      //zapytanie ustwiające pola w tabeli READERS na wartość Not set - potrzebne do testów
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);                                 //wywołanie update - stsujemy dla aktualizacji danych bezpośredniow bazie

        //When
        String sqlProcedureCall = "CALL UpdateVipLevels()";                 //ustawienie procedury aktualizujacej - ma wstawić do READERS wartości VIP_Level
        statement.execute(sqlProcedureCall);                                //wywołanie procedury

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\""; //zapytanie zliczające rekordy z "Not set" (wynik = 0 po wywołaniu VIP_LEVEL)
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if(rs.next()){
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0,howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException{
        //Given
        DbManager dbManager = DbManager.getInstance();                      //nawiązanie połączenia z bazą
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER=false";             //zapytanie ustwiające pola w tabeli READERS na wartość NULL - potrzebne do testów
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);                                 //wywołanie update - stosujemy dla aktualizacji danych bezpośrednio w bazie

        //When
        String sqlProcedureCall = "CALL UpdateBooksBestseller()";           //ustawienie procedury aktualizujacej - ma wstawić do BOOKS wartości BESTSELLER zgiodnie z
        statement.execute(sqlProcedureCall);                                //wywołanie procedury

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER=false"; //zapytanie zliczające rekordy z false (wynik = 1 po wywołaniu UpdateBooksBestseller)
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = 0;
        if(rs.next()){
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(1,howMany);


    }
}
