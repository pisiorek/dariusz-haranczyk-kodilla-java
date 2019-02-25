package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks(){

        //creating the Library
        Library library1 = new Library("Library #1");

        Book book1 = new Book("Title 1", "Author 1", LocalDate.parse("2017-02-03"));
        Book book2 = new Book("Title 2", "Author 2", LocalDate.parse("2017-02-04"));
        Book book3 = new Book("Title 3", "Author 3", LocalDate.parse("2017-02-05"));
        Book book4 = new Book("Title 4", "Author 4", LocalDate.parse("2017-02-06"));
        Book book5 = new Book("Title 5", "Author 5", LocalDate.parse("2017-02-07"));

        library1.getBooks().add(book1);
        library1.getBooks().add(book2);
        library1.getBooks().add(book3);
        library1.getBooks().add(book4);
        library1.getBooks().add(book5);

        //making a shallow clone of object board
        Library clonedLibrary = null;
        try {
            clonedLibrary = library1.shallowCopy();
            clonedLibrary.setName("Library #2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //System.out.println(clonedLibrary);

        //making a deep copy of object board
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library1.deepCopy();
            deepClonedLibrary.setName("Library #3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        boolean isRemoved = library1.getBooks().remove(book1);

        //Then
        System.out.println(library1);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(4, library1.getBooks().size());
        Assert.assertEquals(4, clonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
        Assert.assertTrue(isRemoved);
    }
}
