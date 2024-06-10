public class Ratings {
    protected String UserID;
    protected String ISBN;
    protected String Rating;
    protected Ratings prev;
    protected Ratings next;

    public Ratings(String UserID, String ISBN, String Rating) {
        this.UserID = UserID;
        this.ISBN = ISBN;
        this.Rating = Rating;
    }

    public String toString() {
        return "User-ID:" + UserID + "\nRating:" + Rating;
    }
}
