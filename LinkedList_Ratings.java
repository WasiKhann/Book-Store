public class LinkedList_Ratings {
    protected Ratings head;

    public LinkedList_Ratings() {
        head = null;
    }

    public void insert(String a, String b, String c) {
        Ratings temp;
        Ratings nn = new Ratings(a, b, c);
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

    public void delete(String ISBN) {
        Ratings temp = head;
        Ratings prev = head;
        if (head != null && head.ISBN == ISBN) {
            head = head.next;
        }
        while (temp.next != null && temp.ISBN != ISBN) {
            prev = temp;
            temp = temp.next;
        }
        if (temp.ISBN == ISBN) {
            prev.next = temp.next;
            temp.next = null;
        }
    }

    public void find(String ISBN) {
        Ratings temp = head;
        if ((head != null) && (head.ISBN == ISBN)) {
            System.out.println(head);
        } else
            while (temp.next != null && temp.ISBN != ISBN) {
                temp = temp.next;

            }
        if (temp.ISBN == ISBN)
            System.out.println(temp);
        else
            System.out.println("No ratings found");

    }


    public void print() {
        Ratings temp = head;
        while (temp != null) {
            System.out.println(temp);
            System.out.println();
            temp = temp.next;
        }
    }
}
