package org.example;

import org.example.linkedlistoperations.LinkedListFlipper;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedListFlipper linkedListFlipper = new LinkedListFlipper();
        Integer[] array = new Integer[]{1, 2, 3, 4, -5};
        LinkedList<Integer> originalList = new LinkedList<>(Arrays.asList(array));
        LinkedList<Integer> invertedList = linkedListFlipper.flip(originalList);
        System.out.println(invertedList);

    }
}