package edu.guilford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ListEfficiency {
    public static void main(String[] args) {
        // building lists of many strings objects and getting and sorting them
        final int MAX = 50000;
        ArrayList<String> arrayVersion = new ArrayList<String>();
        LinkedList<String> linkedVersion = new LinkedList<String>();

        // add 100 randomly generated strings to each list
        for (int i = 0; i < MAX; i++) {
            StringBuilder sb = new StringBuilder();
            // 97 is the ASCII value for 'a'; this will generate random letters from a-z
            for (int j = 0; j < 10; j++) {
                sb.append((char) ((int) (Math.random() * 26) + 97));
            }
            arrayVersion.add(sb.toString());
            linkedVersion.add(sb.toString());
        }
        // System.out.println (arrayVersion);
        // time 100000 random gets from the list
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int index = (int) (Math.random() * MAX);
            String s = arrayVersion.get(index);
        }
        long endTime = System.nanoTime();
        System.out.println("Time to get 100000 elements from a, ArrayList: "
                + String.format("%2f", (endTime - startTime) / 1.e6) + " illiseconds");

        // time 100000 random gets from the linked list
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int index = (int) (Math.random() * MAX);
            String s = linkedVersion.get(index);
        }
        endTime = System.nanoTime();
        System.out.println("Time to get 100000 elements from a, LinkedList: "
                + String.format("%2f", (endTime - startTime) / 1.e6) + " illiseconds");

        // time sorting the arrayList implementation
        startTime = System.nanoTime();
        Collections.sort(arrayVersion); // use the available sort method (which is a merge sort)
        endTime = System.nanoTime();
        System.out.println("Time to sort an ArrayList: " +
                String.format("%2f", (endTime - startTime) / 1.e6) + " milliseconds");
        // time sorting the linkedList implementation
        startTime = System.nanoTime();
        Collections.sort(linkedVersion); // use the available sort method (which is a merge sort)
        endTime = System.nanoTime();
        System.out.println("Time to sort a LinkedList: " +
                String.format("%2f", (endTime - startTime) / 1.e6) + " milliseconds");

        // time insorting the arrayList
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            String s = "test String";
            arrayVersion.add(s);
        }
        endTime = System.nanoTime();
        System.out.println("Time to insert 100000 elements into an ArrayList: "
                + String.format("%2f", (endTime - startTime) / 1.e6) + " milliseconds");

        // time insorting the linkedList
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            String s = "test String";
            linkedVersion.add(s);
        }
        endTime = System.nanoTime();
        System.out.println("Time to insert 100000 elements into a LinkedList: "
                + String.format("%2f", (endTime - startTime) / 1.e6) + " milliseconds");
    }
}
