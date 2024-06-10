public class node {
    protected String ISBN;
    protected String bookTitle, publishYear, Author, genre;
    protected node prev;
    protected node next;


    public node(String ISBN, String bookTitle, String publishYear, String author, String genre) {
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.publishYear = publishYear;
        this.Author = author;
        this.genre = genre;


    }

    public String toString() {
        return "\nISBN:" + ISBN + "\nBook Title: " + bookTitle + " \nPublishing Year: " + publishYear + "\nBook Author: " + Author + "\nBook Genre: " + genre;
    }


}

