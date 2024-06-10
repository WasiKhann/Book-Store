public class HashTable_Ratings {
    private final LinkedList_Ratings[] RatingsTable;
    private int size;

    public HashTable_Ratings() {
        int s = 100000;
        RatingsTable = new LinkedList_Ratings[s + (s / 3)];
        size = RatingsTable.length;
        for (int j = 0; j < RatingsTable.length; j++) {
            RatingsTable[j] = new LinkedList_Ratings();
        }
    }

    public int Hash(String ISBN) {
        if (ISBN.hashCode() % size >= 0) {
            return (ISBN.hashCode() % size);
        } else return (ISBN.hashCode() % size) * -1;
    }

    public void InsertRating(String userID, String ISBN, String Rating) {
        int i = Hash(ISBN);
        RatingsTable[i].insert(userID, ISBN, Rating);
    }

    public void showRatings(String ISBN) {
        int i = Hash(ISBN);
        RatingsTable[i].print();
    }
}
