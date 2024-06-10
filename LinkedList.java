public class LinkedList {
    protected node head;

    public LinkedList() {
        head = null;
    }

    public void insert(String a, String b, String c, String d, String e) {
        node temp;
        node nn = new node(a, b, c, d, e);
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

    public void delete(String bookTitle) {
        node temp = head;
        node prev = head;
        if (head != null && head.bookTitle == bookTitle) {
            head = head.next;
        }
        while (temp.next != null && temp.bookTitle != bookTitle) {
            prev = temp;
            temp = temp.next;
        }
        if (temp.bookTitle == bookTitle) {
            prev.next = temp.next;
            temp.next = null;
        }
    }

    public void find(String bookTitle) {
        node temp = head;
        if ((head != null) && (head.bookTitle == bookTitle)) {
            System.out.println(head);
            return;
        }

        while (temp != null && temp.bookTitle != bookTitle) {
            if (temp.next != null)
                temp = temp.next;
            else
                break;
        }

        if (temp.bookTitle.equals(bookTitle))
            System.out.println(temp);
        else
            System.out.println("Book not found");
    }

    public node findISBN(String bookTitle) {
        node temp = head;
        if ((head != null) && (head.bookTitle == bookTitle)) {
            return head;
        }
        while (temp != null && temp.bookTitle != bookTitle) {
            if (temp.next != null)
                temp = temp.next;
            else
                break;
        }
        if (temp != null)
            if (temp.bookTitle.equals(bookTitle)) {
                return temp;
            } else
                System.out.println("ISBN not found");
        return null;
    }

    public void print() {
        node temp = head;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}


