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
            this.element = new ListElement(null, null, null);
            ;
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
        invertedLinkedList.addNext(this.element.data);
        invertedLinkedList.setFirstPtr(null);
        while (before()) {
            invertedLinkedList.addNext(this.element.data);
        }
        return invertedLinkedList;
    }

    public ListElement getNextPtr() {
        return this.element.nextPtr;
    }

    public ListElement getFirstPtr() {
        return this.element.firstPtr;
    }

    public void setNextPtr(ListElement ptr) {
        this.element.nextPtr = ptr;
    }

    public void setFirstPtr(ListElement ptr) {
        this.element.firstPtr = ptr;
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
