public class HashTable {
    private final LinkedList[] TableBook;
    private final LinkedList[] TableYear;
    private final LinkedList[] TableGenre;
    private final LinkedList[] TableAuthor;
    private int size;

    HashTable() {
        int s = 250000;
        TableBook = new LinkedList[s + (s / 3)];
        size = TableBook.length;
        for (int j = 0; j < TableBook.length; j++) {
            TableBook[j] = new LinkedList();
        }
        TableYear = new LinkedList[s + (s / 3)];
        size = TableYear.length;
        for (int j = 0; j < TableYear.length; j++) {
            TableYear[j] = new LinkedList();
        }
        TableGenre = new LinkedList[s + (s / 3)];
        size = TableGenre.length;
        for (int j = 0; j < TableGenre.length; j++) {
            TableGenre[j] = new LinkedList();
        }
        TableAuthor = new LinkedList[s + (s / 3)];
        size = TableAuthor.length;
        for (int j = 0; j < TableAuthor.length; j++) {
            TableAuthor[j] = new LinkedList();
        }
    }

    public int Hash(String Data) {
        if (Data.hashCode() % size >= 0) {
            return (Data.hashCode() % size);
        } else return (Data.hashCode() % size) * -1;
    }

    public void InsertBook(String ID, String bookName, String publishYear, String Author, String Genre) {
        int i = Hash(bookName);
        TableBook[i].insert(ID, bookName, publishYear, Author, Genre);
    }

    public void RemoveBook(String bookName) {
        int i = Hash(bookName);
        TableBook[i].delete(bookName);
    }

    public void SearchBook(String bookName) {
        int i = Hash(bookName);
        if (TableBook[i].head != null)
            TableBook[i].find(bookName);
        else
            System.out.println("Error: Data for this Book Doesnt Exist in our Database");
    }

    public String getISBNbyBook(String bookName) {
        int i = Hash(bookName);
        if (bookName != null)
            return TableBook[i].findISBN(bookName).ISBN;
        return "-1";
    }

    public void displayTableBook() {
        for (int i = 0; i < TableBook.length; i++) {
            TableBook[i].print();
        }
    }

    public void InsertbyYear(String ID, String bookName, String publishYear, String Author, String Genre) {
        int i = Hash(publishYear);
        TableYear[i].insert(ID, bookName, publishYear, Author, Genre);
    }

    public void RemoveYear(String bookName, String publishYear) {
        int i = Hash(publishYear);
        TableYear[i].delete(bookName);
    }

    public void SearchbyYearFilter(String publishYear) {
        int i = Hash(publishYear);
        if (TableYear[i].head != null)
            TableYear[i].print();
        else
            System.out.println("Error: Data for this Year Doesn't Exist in Database");
    }

    public void SearchbyYear(String bookName, String publishYear) {
        int i = Hash(publishYear);

        TableYear[i].find(bookName);
    }

    public void displayTableYear() {
        for (int i = 0; i < TableYear.length; i++) {
            TableYear[i].print();
        }
    }

    public void InsertbyGenre(String ID, String bookName, String publishYear, String Author, String Genre) {
        int i = Hash(Genre);
        TableGenre[i].insert(ID, bookName, publishYear, Author, Genre);
    }

    public void RemoveGenre(String bookName, String Genre) {
        int i = Hash(Genre);
        TableGenre[i].delete(bookName);
    }

    public void SearchbyGenreFilter(String Genre) {
        int i = Hash(Genre);
        TableGenre[i].print();
    }

    public void SearchbyGenre(String bookName, String Genre) {
        int i = Hash(Genre);
        if (TableGenre[i].head != null)
            TableGenre[i].find(bookName);
        else
            System.out.println("Error: Data for this Genre doesn't exist in database");
    }

    public void displayTableGenre() {
        for (int i = 0; i < TableGenre.length; i++) {
            TableGenre[i].print();
        }
    }

    public void InsertbyAuthor(String ID, String bookName, String publishYear, String Author, String Genre) {
        int i = Hash(Author);
        TableAuthor[i].insert(ID, bookName, publishYear, Author, Genre);
    }

    public void RemoveAuthor(String bookName, String Author) {
        int i = Hash(Author);
        TableAuthor[i].delete(bookName);
    }

    public void SearchbyAuthorFilter(String Author) {
        int i = Hash(Author);
        if (TableAuthor[i].head != null)
            TableAuthor[i].print();
        else
            System.out.println("Error: Data for this Author Doesnt Exist in our database");
    }

    public void SearchbyAuthor(String bookName, String Author) {
        int i = Hash(Author);
        TableAuthor[i].find(bookName);
    }

    public void displayTableAuthor() {
        for (int i = 0; i < TableAuthor.length; i++) {
            TableAuthor[i].print();
        }
    }
}
