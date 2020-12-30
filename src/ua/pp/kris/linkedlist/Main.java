package ua.pp.kris.linkedlist;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("wonderful");
        list.add("world!");

        list.forEach(elem -> System.out.println(elem));

        Iterator<String> iteratorReverse = list.iteratorReverse();
        while(iteratorReverse.hasNext()) {
            System.out.println(iteratorReverse.next());
        }
    }
}
