package com.kodilla.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);

        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);

        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {

            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            List<Book> resultListOf0Books = new ArrayList<Book>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);

            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
            // Then

            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());

    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());

    }
    @Test
    public void testListZeroBooksInUserHands() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        LibraryUser user1 = new LibraryUser("Michał", "Kot","pesel1");
        List<Book> resultListOf0Books = new ArrayList<Book>();

        when(libraryDatabaseMock.listBooksInHandsOf(user1)).thenReturn(resultListOf0Books);

        // When
        List<Book> resultList = bookLibrary.listBooksInHandsOf(user1);

        // Then
        assertEquals(0, resultList.size());

    }
    @Test
    public void testListWithOneBookInUserHands() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        Book book1 = new Book("Komu bije dzwon", "Ernest", 1954);

        LibraryUser user1 = new LibraryUser("Michał", "Kot","pesel1");
        List<Book> resultListOfOneBooks = new ArrayList<Book>();
        resultListOfOneBooks.add(book1);

        when(libraryDatabaseMock.listBooksInHandsOf(user1)).thenReturn(resultListOfOneBooks);

        // When
        List<Book> resultList = bookLibrary.listBooksInHandsOf(user1);

        // Then
        assertEquals(1, resultList.size());

    }
    @Test
    public void testListWithFiveBooksInUserHands() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        Book book1 = new Book("Komu bije dzwon", "Ernest", 1954);
        Book book2 = new Book("Komu ", "Kot", 1987);
        Book book3 = new Book("Jeden", "Tre", 1999);
        Book book4 = new Book("Dwa", "jjj", 1952);
        Book book5 = new Book("Trzy", "Erwwwnest", 1953);

        LibraryUser user1 = new LibraryUser("Michał", "Kot","pesel1");
        List<Book> resultListOfFiveBooks = new ArrayList<Book>();
        resultListOfFiveBooks.add(book1);
        resultListOfFiveBooks.add(book2);
        resultListOfFiveBooks.add(book3);
        resultListOfFiveBooks.add(book4);
        resultListOfFiveBooks.add(book5);

        when(libraryDatabaseMock.listBooksInHandsOf(user1)).thenReturn(resultListOfFiveBooks);

        // When
        List<Book> resultList = bookLibrary.listBooksInHandsOf(user1);

        // Then
        assertEquals(5, resultList.size());

    }

}