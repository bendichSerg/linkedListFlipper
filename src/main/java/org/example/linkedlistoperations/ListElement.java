package org.example.linkedlistoperations;


public class ListElement {
    private Integer data;
    private ListElement firstPtr;
    private ListElement nextPtr;


    public ListElement() {
        this.data = null;
        this.firstPtr = null;
        this.nextPtr = null;
    }

    ListElement(Integer data, ListElement firstPtr, ListElement nextPtr) {
        this.data = data;
        this.firstPtr = firstPtr;
        this.nextPtr = nextPtr;
    }

    ListElement(Integer data) {
        this.data = data;
        this.firstPtr = null;
        this.nextPtr = null;
    }


    public static ListElement constructListElement(Integer[] array) {
        if (array == null || array.length == 0) {
            return new ListElement();
        }
        ListElement head = null;
        ListElement tail = null;
        for (int i = 0; i < array.length; ++i) {
            ListElement node = new ListElement();
            node.setData(array[i]);
            if (head == null) {
                head = node;
            } else {
                tail.addLast(node, tail);
            }
            tail = node;
        }
        return head;
    }


    public void printList(ListElement head) {
        ListElement tail = head;
        do {
            System.out.print(tail.getData() + " ");
            if (tail.getNextPtr() == null) {
                break;
            }
            tail = next(tail);
        } while (true);


        System.out.println();
    }


    public void addLast(ListElement node, ListElement tail) {
        node.setFirstPtr(tail);
        this.nextPtr = node;
    }

    public void addFirst(ListElement node, ListElement tail) {
        node.setNextPtr(tail);
        this.firstPtr = node;
    }


    public static ListElement invertList(ListElement head) {
        ListElement invertedTail = null;
        ListElement invertedHead = null;
        ListElement tail = head;

        do {
            ListElement node = new ListElement(tail.getData());
            if (invertedHead == null) {
                invertedHead = node;
            } else {
                invertedTail.addFirst(node, invertedTail);
            }
            invertedTail = node;

            if (tail.getNextPtr() == null) {
                break;
            }
            tail = next(tail);
        } while (true);

        return invertedTail;
    }

    public static ListElement next(ListElement head) {
        return head.getNextPtr() == null ? head : head.getNextPtr();
    }


    public static ListElement before(ListElement head) {
        return head.getFirstPtr() == null ? head : head.getFirstPtr();
    }

    public void setNextPtr(ListElement nextPtr) {
        this.nextPtr = nextPtr;
    }

    public void setFirstPtr(ListElement firstPtr) {
        this.firstPtr = firstPtr;
    }

    public void setData(Integer element) {
        this.data = element;
    }

    public Integer getData() {
        return this.data;
    }

    public ListElement getFirstPtr() {
        return firstPtr;
    }

    public ListElement getNextPtr() {
        return nextPtr;
    }
}
