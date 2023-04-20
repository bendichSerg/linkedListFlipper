package org.example;

import org.example.linkedlistoperations.OurLinkedList;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, -5, 6};
        OurLinkedList ourLinkedList = new OurLinkedList(array);

        ourLinkedList.printList();
        OurLinkedList invertedList = ourLinkedList.invertList();
        invertedList.printList();
    }
}