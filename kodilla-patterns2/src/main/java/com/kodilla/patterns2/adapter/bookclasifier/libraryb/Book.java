package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

public class Book {
    private final String author;
    private final String title;
    private final int yearOfPublication;

    public Book(String author, String title, int yearOfPublication) {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (yearOfPublication != book.yearOfPublication) return false;
        if (!author.equals(book.author)) return false;
        return title.equals(book.title);

    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + yearOfPublication;
        return result;
    }
}
