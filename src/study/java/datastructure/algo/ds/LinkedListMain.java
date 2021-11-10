package study.java.datastructure.algo.ds;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList theLinkedList = new LinkedList();

//        theLinkedList.insertFirstLink(new Link("Don Quixote", 500));
//        theLinkedList.insertFirstLink(new Link("A Tale of Two Cities", 200));
//        theLinkedList.insertFirstLink(new Link("The Lord of the Rings", 150));
//        theLinkedList.insertFirstLink(new Link("Harry Potter and the Sorcerer's Stone", 107));
//
//        theLinkedList.removeFirst();
//
//        System.out.println(theLinkedList.find("The Lord of the Rings").bookName + " Was Found");
//
//        theLinkedList.removeLink("The Lord of the Rings");
//
//        theLinkedList.displayAll();

        theLinkedList.insert(new Link("Sherlock Holmes", 1000));

        theLinkedList.insert(new Link("Book name", 10));

        theLinkedList.displayAll();
    }
}

class Link {

    public String bookName;
    public int copiesSold;
    public Link next;

    public Link(String bookName, int copiesSold) {

        this.bookName = bookName;
        this.copiesSold = copiesSold;
    }

    public void display() {
        System.out.println(bookName + ": " + copiesSold);
    }

    public String toString() {
        return bookName;
    }

}

class LinkedList {

    public Link firstLink;

    LinkedList() {
        firstLink = null;
    }

    public boolean isEmpty() {
        if (firstLink == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertFirstLink(Link newLink) {

        if (firstLink != null) {
            newLink.next = firstLink;
            firstLink = newLink;
        } else {
            firstLink = newLink;
        }
    }

    public void insert(Link newLink) {
        Link current = firstLink;
        Link previous = null;

        if (isEmpty()) {
            firstLink = newLink;
        } else {
            while (current != null) {
                previous = current;
                current = current.next;
            }
            current = newLink;
            previous.next = current;
        }
    }

    public Link removeFirst() {

        Link linkRef = firstLink;

        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
        } else {
            firstLink = firstLink.next;
        }

        return linkRef;
    }

    public void displayAll() {

        Link currentLink = firstLink;

        System.out.println("First link: ");

        while (currentLink != null) {

            currentLink.display();

            System.out.println("Next Link: " + currentLink.next + "\n");

            currentLink = currentLink.next;
        }
    }

    public Link find(String bookName) {

        Link currentLink = firstLink;

        if (isEmpty()) {
            return null;
        } else {
            while (currentLink.bookName != bookName) {
                if (currentLink.next == null){
                    System.out.println("Link not found");
                    return null;
                } else {
                    currentLink = currentLink.next;
                }
            }
        }

        return currentLink;
    }

    public void removeLink(String bookName) {

        Link currentLink = firstLink;
        Link previousLink = firstLink;

        if (isEmpty()) {
            System.out.println("Linked list is empty");
        } else {
            if (firstLink.bookName == bookName) {
                System.out.println(firstLink.bookName + " Removed");
                firstLink = firstLink.next;
            } else {
                while (!currentLink.bookName.equals(bookName)) {
                    if (currentLink.next == null) {
                        System.out.println("Link not found");
                    } else {
                        previousLink = currentLink;
                        currentLink = currentLink.next;
                    }
                }
                previousLink.next = currentLink.next;
                System.out.println(currentLink.bookName + " Removed");
            }
        }
    }

}
