package org.example.linkedlistoperations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OurLinkedListTest {
    OurLinkedList ourLinkedList = new OurLinkedList();

    @Test
    void getElementTest() {
        Integer element = 9;
        ourLinkedList.addBefore(element);
        assertEquals(ourLinkedList.getElement(), element);
    }

    @Test
    void addBeforeTest() {
        Integer elementA = 9;
        ourLinkedList.addBefore(elementA);
        assertEquals(ourLinkedList.getElement(), elementA);

        Integer elementB = 8;
        ourLinkedList.addBefore(elementB);
        assertEquals(ourLinkedList.getElement(), elementB);

        Integer elementC = 7;
        ourLinkedList.next();
        ourLinkedList.addBefore(elementC);
        assertEquals(ourLinkedList.getElement(), elementC);

    }

    @Test
    void invertListTest() {
        Integer[] array = new Integer[]{1, 2, 3, 4, -5, 6};
        OurLinkedList linkedListTest = new OurLinkedList(array);
        OurLinkedList invertedLinkedListTest = linkedListTest.invertList();
        assertArrayEquals(invertedLinkedListTest.fromListToArray(), new Integer[]{6, -5, 4, 3, 2, 1});
    }

    @Test
    void invertNullListTest() {
        OurLinkedList linkedListTest = new OurLinkedList(null);
        OurLinkedList invertedLinkedListTest = linkedListTest.invertList();
        assertNull(invertedLinkedListTest.getElement());
    }

    @Test
    void emptyArrayListConstructTest() {
        OurLinkedList linkedListTest = new OurLinkedList(null);
        assertEquals(linkedListTest.getSize(), 0);
    }
}