package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookStatistics;

import java.util.*;

public class MedianAdapter extends MedianAdaptee implements Classifier{

    @Override
    public int publicationYearMedian(Set<Book> bookSet){

        Map<BookSignature, Book> bookMap = new HashMap<>();
        int counterBook = 0;
        for(Book book: bookSet){
            bookMap.put(new BookSignature(String.valueOf(counterBook)), book);
            counterBook++;
        }
        return medianPublicationYear(bookMap);
    }
/*    @Override
    public int publicationYearMedian(Set<Book> bookSet){
        Map<BookSignature, Book> bookMap = new HashMap<>();
        BookSignature signature = new BookSignature(bookSet.getClass().getS)
        Book n = new Book("tt", "jj", 1900, "jj");
        for(int i = 0; i < bookSet.size(); i++){
            bookMap.put(new BookSignature("1"), n );
        }
        return bookMap;
    }*/

}
