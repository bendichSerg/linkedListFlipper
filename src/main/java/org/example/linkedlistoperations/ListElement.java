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

    public static ListElement constructListElement(Integer[] array) {
        if (array == null || array.length == 0) {
            return new ListElement();
        }
        ListElement head = new ListElement();
        for (int i = 0; i < array.length; ++i) {
            head = addLast(array[i], head);
        }
        return goBeginning(head);
    }


    public void printList(ListElement head) {
        head = goBeginning(head);
        if (head.getData() == null) {
            return;
        }
        while (head.getNextPtr() != null) {
            System.out.print(head.getData() + " ");
            head = next(head);
        }
        if (head.getData() != null) {
            System.out.print(head.getData() + " ");
        }

        System.out.println();
    }


    public static ListElement addLast(Integer element, ListElement head) {
        ListElement node = new ListElement(element, head, null);
        head.setNextPtr(node);
        return node;
    }

    public static ListElement addFirst(Integer element, ListElement head) {
        ListElement node = new ListElement(element, null, head);
        head.setFirstPtr(node);
        return node;
    }


    public static ListElement invertList(ListElement head) {
        ListElement invertedListHead = new ListElement();
        while (head.getNextPtr() != null) {
            invertedListHead = addFirst(head.getData(), invertedListHead);
            head = next(head);
        }
        invertedListHead = addFirst(head.getData(), invertedListHead);

        return invertedListHead;
    }

    public ListElement goEnd(ListElement head) {
        while (head.getNextPtr() != null) {
            head = next(head);
        }
        return head;
    }

    public static ListElement goBeginning(ListElement head) {
        while (head.getFirstPtr() != null) {
            head = before(head);
        }
        if (head.getData() == null) {
            head = next(head);
        }
        return head;
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
