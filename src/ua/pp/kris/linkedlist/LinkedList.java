package ua.pp.kris.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedList<T> implements Iterable<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        Node cur = head;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            T val = (T)cur.value;
            cur = cur.next;
            return val;
        }
    }

    public Iterator<T> iteratorReverse(){
        return new LinkedListReverseIterator();
    }

    private class LinkedListReverseIterator implements Iterator<T> {
        Node cur = tail;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            T val = (T)cur.value;
            cur = cur.prev;
            return val;
        }
    }

    private static class Node {
        Object value;
        Node next;
        Node prev;

        public Node(Object value, Node prev, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public void add (T value) {
        Node n = new Node(value, tail, null);
        if(head==null){
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public boolean remove (T value) {
        Node prev = null;
        Node cur = head;

        while(cur != null) {
            if(cur.value.equals(value)) {
                if(prev != null) {
                    prev.next = cur.next;
                    if(cur.next == null) {
                        tail = prev;
                    }
                      else {
                    cur.next.prev = prev;
                    }
                size--;
                } else {
                if(null!= head) head = head.next;
            }
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public T get(int index) {
        checkIndex(index);
        Node cur = getNodeByIndex(index);
        return (T)cur.value;
    }

    public void set(int index, T value) {
        checkIndex(index);
        Node cur = getNodeByIndex(index);
        cur.value=value;
    }

    @Override
    public void forEach(Consumer <? super T> consumer) {
        for (Node cur = head; cur != null; cur = cur.next) {
            consumer.accept((T)cur.value);
        }
    }

    private Node getNodeByIndex(int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) cur=cur.next;
        return cur;
    }

    private void checkIndex(int index) {
        if(index <0 || index >=size) throw new IndexOutOfBoundsException();
    }
}
