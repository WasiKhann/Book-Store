class item {
    protected String booktitle;
    protected item next;
    protected item prev;

    public item(String booktitle) {
        this.booktitle = booktitle;
    }
}

public class WishList {
    item head;

    public void InsertforWishlist(String a) {
        item temp;
        item nn = new item(a);
        if (head == null) {
            head = nn;
        } else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nn;
            nn.prev = temp;
        }
    }

    public String toString() {
        item temp = head;
        String data = " ";
        while (temp != null) {
            data = data + temp.booktitle + ", ";
            temp = temp.next;
        }
        return data;
    }

    public static void main(String[] args) {
        WishList a = new WishList();
        a.InsertforWishlist("Bookdata");
        a.InsertforWishlist("Bookdata");
        System.out.println(a);
    }

}
