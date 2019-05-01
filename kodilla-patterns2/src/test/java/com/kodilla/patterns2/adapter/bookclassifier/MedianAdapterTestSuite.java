package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdaptee;
import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest(){

        //Given
        Book book1 = new Book("Author1","Title1",10,"001");
        Book book2 = new Book("Author2","Title2",20,"002");
        Book book3 = new Book("Author3","Title3",30,"003");
        Book book4 = new Book("Author4","Title4",40,"004");
        Book book5 = new Book("Author5","Title4",50,"005");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        MedianAdapter medianAdapter = new MedianAdapter();
        int medianYear = medianAdapter.publicationYearMedian(bookSet);

        //Then
        System.out.println(medianYear);
        assertEquals(30,medianYear, 0);




    }
}
