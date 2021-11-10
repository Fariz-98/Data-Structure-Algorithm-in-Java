package study.java.datastructure.algo.ds;

public class DoublyLinkedListMain {

    public static void main(String[] args) {

        DoublyLinkedList theLinkedList = new DoublyLinkedList();

//        theLinkedList.insertInFirstPosition("Mark Evans", 7);
//        theLinkedList.insertInFirstPosition("Piers Polkiss", 9);
//        theLinkedList.insertInFirstPosition("Doreen Figg", 6);
//        theLinkedList.insertInLastPosition("Petunia Dursley", 4);


        theLinkedList.insertInOrder("Mark Evans", 7);
        theLinkedList.insertInOrder("Piers Polkiss", 9);
        theLinkedList.insertInOrder("Doreen Figg", 6);
        theLinkedList.insertInOrder("Petunia Dursley", 4);


        theLinkedList.display();

        System.out.println("\n");

        theLinkedList.insertAfterKey("Derek Banas", 2, 6);

        theLinkedList.display();

        System.out.println("\n");

        Iterator iterator = new Iterator(theLinkedList);

        iterator.currentNeighbor.display();

        System.out.println(iterator.hasNext());

        iterator.next();

        iterator.currentNeighbor.display();

        iterator.remove();

        iterator.currentNeighbor.display();
        iterator.prevNeighbor.display();





    }

}

class Neighbor {

    public String homeOwnerName;
    public int homeNumber;

    public Neighbor next;
    public Neighbor prev;

    public Neighbor(String homeOwnerName, int homeNumber) {

        this.homeOwnerName = homeOwnerName;
        this.homeNumber = homeNumber;
    }

    public void display() {

        System.out.println(homeOwnerName + ": " + homeNumber);
    }

    public String toString() {

        return homeOwnerName;
    }
}

class DoublyLinkedList {

    Neighbor firstLink;
    Neighbor lastLink;

    public boolean isEmpty() {

        return (firstLink == null);
    }

    public void display() {

        Neighbor currentNeighbor = firstLink;

        while (currentNeighbor != null) {

            currentNeighbor.display();

            System.out.println("Next link: " + currentNeighbor.next);

            currentNeighbor = currentNeighbor.next;

            System.out.println();
        }
    }

    public void insertInFirstPosition(String homeOwnerName, int homeNumber) {

        Neighbor theNewLink = new Neighbor(homeOwnerName, homeNumber);

        if (isEmpty()) {

            lastLink = theNewLink;
            lastLink.next = null;
        } else {

            theNewLink.next = firstLink;
            firstLink.prev = theNewLink;
        }

        firstLink = theNewLink;
    }

    public void insertInLastPosition(String homeOwnerName, int homeNumber) {

        Neighbor theNewLink = new Neighbor(homeOwnerName, homeNumber);

        if (isEmpty()) {

            firstLink = theNewLink;
        } else {

            theNewLink.next = null;
            theNewLink.prev = lastLink;
            lastLink.next = theNewLink;
        }

        lastLink = theNewLink;
    }

    public boolean insertAfterKey(String homeOwnerName, int homeNumber, int key) {

        Neighbor theNewLink = new Neighbor(homeOwnerName, homeNumber);

        Neighbor currentNeighbor = firstLink;

        if (isEmpty()) {
            firstLink = theNewLink;
            lastLink = theNewLink;
        }

        while (currentNeighbor.homeNumber != key) {

            currentNeighbor = currentNeighbor.next;

            if (currentNeighbor == null) {
                return false;
            }
        }

        // If the key matches the first home
        if (currentNeighbor == firstLink) {

            theNewLink.next = currentNeighbor.next;
            currentNeighbor.next = theNewLink;
            return true;
        } else if (currentNeighbor == lastLink) {

            lastLink.next = theNewLink;
            theNewLink.prev = lastLink;
            theNewLink.next = null;
            lastLink = theNewLink;
            return true;
        }

        theNewLink.next = currentNeighbor.next;
        currentNeighbor.next.prev = theNewLink;
        currentNeighbor.next = theNewLink;
        theNewLink.prev = currentNeighbor;
        return true;
    }

    public void insertInOrder(String homeOwnerName, int homeNumber) {

        Neighbor theNewLink = new Neighbor(homeOwnerName, homeNumber);

        Neighbor currentNeighbor = firstLink;
        Neighbor prevNeighbor = null;

        if (isEmpty()) { // If the list is empty

            firstLink = theNewLink;
            lastLink = theNewLink;
            return;
        }

        while (homeNumber > currentNeighbor.homeNumber) {

            if (currentNeighbor.next == null) { // If we're at the last item in the list
                lastLink.next = theNewLink;
                theNewLink.prev = lastLink;
                return;
            }
            prevNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.next;
        }

        // If we're at the first item in the list
        if (prevNeighbor == null) {

            theNewLink.next = firstLink;
            firstLink.prev = theNewLink;
            firstLink = theNewLink;
            return;
        } else {

            prevNeighbor.next = theNewLink;
            currentNeighbor.prev = theNewLink;
            theNewLink.next = currentNeighbor;
            theNewLink.prev = prevNeighbor;
            return;
        }
    }

}

class Iterator {

    DoublyLinkedList theList;
    Neighbor currentNeighbor;
    Neighbor prevNeighbor;

    public Iterator(DoublyLinkedList theList) {
        this.theList = theList;
        currentNeighbor = this.theList.firstLink;
        prevNeighbor = null;
    }

    public boolean hasNext() {

        if (currentNeighbor.next != null) {
            return true;
        } else {
            return false;
        }
    }

    public Neighbor next() {

        if (currentNeighbor.next == null) {

            prevNeighbor = null;
            return currentNeighbor;
        }

        if (currentNeighbor == null) {

            return null;
        }

            prevNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.next;
            return currentNeighbor;
    }

    public void remove() {

        // If there's only one item in the list
        if (prevNeighbor == null && currentNeighbor.next == null) {
            currentNeighbor = null;
            return;
        }
        // If we're at the first item in the list
        if (prevNeighbor == null) {
            currentNeighbor = currentNeighbor.next;
            return;
        } else if (currentNeighbor.next == null) { // If we're at the last item in the list
            prevNeighbor = prevNeighbor.prev;
            currentNeighbor = prevNeighbor.next;
            currentNeighbor.next = null;
            return;
        } else {
            prevNeighbor.next = currentNeighbor.next;
            currentNeighbor = currentNeighbor.next;
            currentNeighbor.prev = prevNeighbor;
            return;
        }
    }
}
