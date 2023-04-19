package org.example.linkedlistoperations;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListFlipper {


    public LinkedList<Integer> flip(LinkedList<Integer> originalList) {
        if (originalList == null || originalList.isEmpty()) {
            return new LinkedList<>();
        }
        LinkedList<Integer> invertedList = new LinkedList<>();
        Iterator<Integer> originalIterator = originalList.descendingIterator();
        while (originalIterator.hasNext()) {
            invertedList.add(originalIterator.next());
        }
        return invertedList;
    }


}
