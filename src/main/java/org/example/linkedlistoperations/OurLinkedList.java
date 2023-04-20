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
        if (array == null || array.length == 0) {
            this.element = null;
            return;
        }
        addFirstElement(array[0]);
        for (int i = 1; i < array.length; ++i, ++this.size) {
            addNext(array[i]);
        }
        goBeginning();
    }

    private void addFirstElement(Integer element) {
        this.element = new ListElement(null, null, null);
        addNext(element);
        ++this.size;
        this.element.firstPtr = null;
    }

    public Integer getElement() {
        return this.element.data;
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


    public boolean invertList() {
        goEnd();
        if (isEmpty()) {
            return false;
        }
        ListElement tmpEl;
        do {
            tmpEl = this.element.nextPtr;
            this.element.nextPtr = this.element.firstPtr;
            this.element.firstPtr = tmpEl;
        } while (next());

        return true;
    }

    public void goEnd() {
        while (next()) {
        }
    }

    public void goBeginning() {
        while (before()) {
        }
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
