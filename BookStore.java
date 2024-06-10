import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookStore {

    public HashTable BooksInitializer() throws IOException {
        HashTable a = new HashTable();
        String path = "C:\\Users\\Wasi Khan\\Desktop\\Book Store - Data Structures Course\\Book Store - Data Structures Course\\src\\dataset_duplicate.csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] records = line.split(",");
                String ISBN = records[1];
                String bookTitle = records[2];
                String author = records[3];
                String genre = records[4];
                String year = records[5];
                a.InsertBook(ISBN, bookTitle, year, author, genre);
                a.InsertbyAuthor(ISBN, bookTitle, year, author, genre);
                a.InsertbyGenre(ISBN, bookTitle, year, author, genre);
                a.InsertbyYear(ISBN, bookTitle, year, author, genre);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }


    public HashTable_Ratings RatingsInitializer() throws IOException {
        String pathFile = "C:\\Users\\Wasi Khan\\Desktop\\Book Store - Data Structures Course\\Book Store - Data Structures Course\\src\\BX-Book-Ratings.csv";
        HashTable_Ratings insertRatings = new HashTable_Ratings();

        BufferedReader newBR = new BufferedReader(new FileReader(pathFile));
        String newLine = "";
        try {
            while ((newLine = newBR.readLine()) != null) {
                String[] newRecords = newLine.split(";");
                String userID = newRecords[0];
                String newISBN = newRecords[1];
                String rating = newRecords[2];
                insertRatings.InsertRating(userID, newISBN, rating);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return insertRatings;

    }

    public WishList InitializeWishList() {
        WishList WishList = new WishList();
        return WishList;
    }

    public void bookStoreRunner(WishList WishList, HashTable Store, HashTable_Ratings User_Ratings) throws InputMismatchException {
        int loopCounter;
        int loopCounterBook;
        int loopCounterAuthor;
        int loopCounterGenre;

        Scanner input = new Scanner(System.in);
        do {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Choose An Option From Below:");
            System.out.println("Press 1: Search By Book Title");
            System.out.println("Press 2: Search By Author");
            System.out.println("Press 3: Search By Genre");
            System.out.println("Press 4: Search By Publishing Year");
            System.out.println("Press 5: View My 'WishList' ");
            System.out.println("Press 6: Exit");
            System.out.println("-----------------------------------------------------------------------------------");
            loopCounter = input.nextInt();
            switch (loopCounter) {
                case 1:
                    do {
                        Scanner a = new Scanner(System.in);
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("Choose An Option From Below:");
                        System.out.println("Press 1: To Enter Book Title");
                        System.out.println("Press 2: To Print Entire Book Data");
                        System.out.println("Press 3: Exit");
                        System.out.println("-----------------------------------------------------------------------------------");
                        loopCounterBook = a.nextInt();
                        switch (loopCounterBook) {
                            case 1:
                                try {
                                    Scanner bstr = new Scanner(System.in);
                                    Scanner bint = new Scanner(System.in);
                                    System.out.println("Input Book Name");
                                    String inputBookName = bstr.nextLine();
                                    Store.SearchBook(inputBookName);
                                    System.out.println();

                                    System.out.println("Press-1: To view Ratings for this books");
                                    System.out.println("Press 2: Exit");
                                    int viewRatings = bint.nextInt();
                                    if (viewRatings == 1) {
                                        System.out.println("Ratings:");
                                        String ISBNvalue = Store.getISBNbyBook(inputBookName);

                                        if (ISBNvalue != null)
                                            User_Ratings.showRatings(ISBNvalue);
                                        else
                                            System.out.println("No Rating");

                                        System.out.println("Press 1 - To Add a book to your 'WishList' ");
                                        System.out.println("Press 2 - Exit");
                                        int selection = bint.nextInt();
                                        if (selection == 1) {
                                            WishList.InsertforWishlist(inputBookName);
                                        } else break;
                                    } else break;
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Enter valid value");

                                }
                            case 2:
                                Scanner cstr = new Scanner(System.in);
                                Scanner cint = new Scanner(System.in);
                                Store.displayTableBook();
                                System.out.println("Press-1: To view Ratings for any of these books");
                                System.out.println("Press-2: Exit");
                                int viewRatings1 = cint.nextInt();
                                if (viewRatings1 == 1) {
                                    System.out.println("Enter a Book Name to view Ratings");
                                    String inputBookName1 = cstr.nextLine();
                                    System.out.println("Ratings:");
                                    String ISBNvalue = Store.getISBNbyBook(inputBookName1);
                                    if (ISBNvalue != null)
                                        User_Ratings.showRatings(ISBNvalue);
                                    else
                                        System.out.println("No Rating");

                                    System.out.println("Press 1 - To Add a book to your 'WishList' ");
                                    System.out.println("Press 2 - Exit");
                                    int selection = cint.nextInt();
                                    if (selection == 1) {
                                        WishList.InsertforWishlist(inputBookName1);
                                    }
                                } else break;
                                break;
                            default:
                                System.out.println("Enter Valid Value");

                        }
                    } while (loopCounterBook != 3);
                    break;
                case 2:
                    do {
                        Scanner e = new Scanner(System.in);
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("Choose An Option From Below:");
                        System.out.println("Press 1: Filter By Author Name");
                        System.out.println("Press 2: Exit");
                        System.out.println("-----------------------------------------------------------------------------------");
                        loopCounterAuthor = e.nextInt();
                        switch (loopCounterAuthor) {
                            case 1:
                                Scanner estr = new Scanner(System.in);
                                Scanner eint = new Scanner(System.in);
                                System.out.println("Type Author Name");
                                String inputAuthorName = estr.nextLine();
                                Store.SearchbyAuthorFilter(inputAuthorName);
                                System.out.println("Press-1: To get Ratings");
                                System.out.println("Press-2: Exit");
                                //Scanner g = new Scanner(System.in);
                                int viewRatings2 = eint.nextInt();
                                if (viewRatings2 == 1) {
                                    System.out.println("Enter Book Name:");
                                    String inputBookName2 = estr.nextLine();
                                    System.out.println("Ratings:");
                                    String ISBNvalue = Store.getISBNbyBook(inputBookName2);
                                    if (ISBNvalue != null)
                                        User_Ratings.showRatings(ISBNvalue);
                                    else
                                        System.out.println("No Rating");

                                    System.out.println("Do you want to add this book to your 'WishList' ? - Press 1");
                                    System.out.println("Exit - Press 2");
                                    int selection = eint.nextInt();
                                    if (selection == 1) {
                                        WishList.InsertforWishlist(inputBookName2);
                                    } else break;
                                } else
                                    break;
                                break;
                        }
                    } while (loopCounterAuthor != 2);
                    break;
                case 3:
                    do {
                        Scanner f = new Scanner(System.in);
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("Press 1 - Choose A Genre From Below:");
                        System.out.println("Fantasy");
                        System.out.println("Fiction");
                        System.out.println("History");
                        System.out.println("Humor");
                        System.out.println("Adventure");
                        System.out.println("Health & Fitness");
                        System.out.println("Biography & Autobiography");
                        System.out.println("Comics & Graphic Novels");
                        System.out.println("Business & Economics");
                        System.out.println("Press 2 - Exit");
                        System.out.println("-----------------------------------------------------------------------------------");
                        loopCounterGenre = f.nextInt();
                        switch (loopCounterGenre) {
                            case 1:
                                Scanner gint = new Scanner(System.in);
                                Scanner gstr = new Scanner(System.in);
                                Scanner gstrnew = new Scanner(System.in);
                                System.out.println("Enter Genre:");
                                String choice = gstr.nextLine();
                                String choice_concat = "['" + choice + "']";
                                Store.SearchbyGenreFilter(choice_concat);
                                System.out.println("Press-1: To view Ratings for any of these books");
                                System.out.println("Press-2: Exit");
                                int viewRatings1 = gint.nextInt();
                                if (viewRatings1 == 1) {
                                    System.out.println("Enter a Book Name to view Ratings");
                                    String inputBookName3 = gstrnew.nextLine();
                                    System.out.println("Ratings:");
                                    String ISBNvalue = Store.getISBNbyBook(inputBookName3);
                                    if (ISBNvalue != null)
                                        User_Ratings.showRatings(ISBNvalue);
                                    else
                                        System.out.println("No Rating");

                                    System.out.println("Press 1 - To Add a book to your 'WishList' ");
                                    System.out.println("Press 2 - Exit");
                                    int selection = gint.nextInt();
                                    if (selection == 1) {
                                        WishList.InsertforWishlist(inputBookName3);
                                    }
                                } else break;
                                break;
                        }
                    } while (loopCounterGenre != 2);
                    break;
                case 4:
                    do {
                        Scanner h = new Scanner(System.in);
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("Choose An Option From Below:");
                        System.out.println("Press 1: Filter By Publishing Year");
                        System.out.println("Press 2: Exit");
                        System.out.println("-----------------------------------------------------------------------------------");
                        loopCounterAuthor = h.nextInt();
                        switch (loopCounterAuthor) {
                            case 1:
                                Scanner hstr = new Scanner(System.in);
                                Scanner hint = new Scanner(System.in);
                                System.out.println("Type Year(With a '.0' like 2002.0 )");
                                String inputPublishingYear = hstr.nextLine();
                                Store.SearchbyYearFilter(inputPublishingYear);
                                System.out.println("Press-1: To get Ratings");
                                System.out.println("Press-2: Exit");
                                //Scanner g = new Scanner(System.in);
                                int viewRatings2 = hint.nextInt();
                                if (viewRatings2 == 1) {
                                    System.out.println("Enter Book Name:");
                                    String inputBookName4 = hstr.nextLine();
                                    System.out.println("Ratings:");
                                    String ISBNvalue = Store.getISBNbyBook(inputBookName4);
                                    if (ISBNvalue != null)
                                        User_Ratings.showRatings(ISBNvalue);
                                    else
                                        System.out.println("No Rating");

                                    System.out.println("Do you want to add this book to your 'WishList' ? - Press 1");
                                    System.out.println("Exit - Press 2");
                                    int selection = hint.nextInt();
                                    if (selection == 1) {
                                        WishList.InsertforWishlist(inputBookName4);
                                    } else break;
                                } else
                                    break;
                                break;
                        }
                    } while (loopCounterAuthor != 2);
                    break;

                case 5:
                    System.out.println("My Wishlist:");
                    System.out.println(WishList);
                    break;
                case 6:
                    System.exit(0);
            }
        } while (loopCounter != 6);
    }

    public static void main(String[] args) throws IOException {
        boolean run = true;
        while (run) {
            try {
                BookStore a = new BookStore();
                HashTable books = a.BooksInitializer();
                HashTable_Ratings ratings = a.RatingsInitializer();
                WishList List = a.InitializeWishList();
                a.bookStoreRunner(List, books, ratings);

            } catch (InputMismatchException e) {
                System.out.println("Enter Valid Value");
                BookStore a = new BookStore();
                HashTable books = a.BooksInitializer();
                HashTable_Ratings ratings = a.RatingsInitializer();
                WishList List = a.InitializeWishList();
                a.bookStoreRunner(List, books, ratings);
            } catch (NullPointerException e) {
                System.out.println("Please Enter valid value for the given field");
                BookStore a = new BookStore();
                HashTable books = a.BooksInitializer();
                HashTable_Ratings ratings = a.RatingsInitializer();
                WishList List = a.InitializeWishList();
                a.bookStoreRunner(List, books, ratings);
            }
        }
    }
}



