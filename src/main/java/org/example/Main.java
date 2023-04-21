package org.example;

import org.example.linkedlistoperations.ListElement;

public class Main {
    public static void main(String[] args) {


        Integer[] array = new Integer[]{0, 1, 2, 5, -5};
        ListElement listElement = ListElement.constructListElement(array);
        listElement.printList(listElement);

        ListElement flippedListHead = ListElement.invertList(listElement);
        flippedListHead.printList(flippedListHead);
    }
}