package org.example.linkedlistoperations;

public class OurLinkedList {

    ListElement element;
    private int size = 0;

    private static class ListElement {
        public Integer data;
        public ListElement firstPtr;
        public ListElement nextPtr;


        ListElement(Integer data, ListElement firstPtr, ListElement nextPtr) {
            this.data = data;
            this.firstPtr = firstPtr;
            this.nextPtr = nextPtr;
        }

    }

    public OurLinkedList() {
        this.element = new ListElement(null, null, null);
    }

    public OurLinkedList(Integer[] array) {
        this.element = new ListElement(null, null, null);
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; ++i, ++this.size) {
            addNext(array[i]);
        }
        goBeginning();
    }


    public Integer[] fromListToArray() {
        Integer[] array = new Integer[getSize()];
        goBeginning();
        int i = 0;
        do {
            array[i++] = getElement();
        } while (next());
        return array;
    }

    public Integer getElement() {
        return this.element.data;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setElement(Integer element) {
        this.element.data = element;
    }

    public void printList() {
        goBeginning();
        do {
            System.out.print(this.element.data + " ");
        } while (next());

        System.out.println();
    }


    public void addNext(Integer element) {
        ListElement insertedEl = new ListElement(element, this.element, this.element.nextPtr);
        this.element.nextPtr = insertedEl;
        this.element = insertedEl;
    }


    public void addBefore(Integer element) {
        ListElement insertedEl = new ListElement(element, this.element.firstPtr, this.element);
        this.element.firstPtr = insertedEl;
        this.element = insertedEl;
    }


    public OurLinkedList invertList() {
        OurLinkedList invertedLinkedList = new OurLinkedList();
        goEnd();
        if (isEmpty()) {
            return invertedLinkedList;
        }
        do {
            invertedLinkedList.addNext(this.element.data);
        } while (before() && this.element.data != null);
        return invertedLinkedList;
    }

    public void goEnd() {
        while (next()) {
        }
    }

    public void goBeginning() {
        while (before()) {
        }
        next();
    }


    public boolean next() {
        if (this.element.nextPtr != null) {
            this.element = this.element.nextPtr;
            return true;
        }
        return false;
    }


    public boolean before() {
        if (this.element.firstPtr != null) {
            this.element = this.element.firstPtr;
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

}
