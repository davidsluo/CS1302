package LinkedList;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by David on 11/21/2016.
 */
public class SortedDoublyLinkedList<T extends Comparable<T>> implements Serializable, Iterable<T> {
    private int     size       = 0;
    private Node<T> head, tail = null;


    public boolean add(T obj) {
        Node<T> cursor = tail;
        Node<T> node   = new Node<T>(obj);

        if (obj == null)
            return false;

        // Loop through list until it finds a node with an element that is greater than <obj>
        while (cursor != null) {
            int comparison = cursor.getData().compareTo(obj);
            if (comparison == 0)
                return false;
            else if (comparison > 0) {

                node.setNext(cursor);

                if (cursor.hasPrev()) {
                    node.setPrev(cursor.prev());
                    cursor.prev().setNext(node);
                } else {
                    tail = node;
                }

                cursor.setPrev(node);
                size++;
                return true;

            }
//            else if (comparison < 0) {
//                // do nothing?
//            }

            cursor = cursor.next();
        }

        if (head != null) {
            head.setNext(node);
            node.setPrev(head);
        }
        if (tail == null) {
            tail = node;
        }
        head = node;
        size++;
        return true;

    }

    public boolean remove(T obj) {
        Node<T> cursor = tail;
        if (cursor == null)
            return false;
        while (cursor != null) {
            if (cursor.getData().equals(obj)) {
                if (cursor.hasPrev()) {
                    cursor.prev().setNext(cursor.next());
                } else {
                    tail = cursor.next();
                }
                if (cursor.hasNext()) {
                    cursor.next().setPrev(cursor.prev());
                } else {
                    head = cursor.prev();
                }
                size--;
                return true;
            }

            cursor = cursor.next();
        }

        return false;

    }

    /**
     * O(n)
     *
     * @param index
     * @return
     */
    public T get(int index) {
        Node<T> cursor = tail;
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        else {
            for (int i = 0; i < index; i++) {
                cursor = cursor.next();
            }
            return cursor.getData();
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    private void printList() {
        for (T obj : this) {
            System.out.println(obj.toString());
        }
    }

    public SortedDoublyLinkedList<T> merge(SortedDoublyLinkedList<? extends T> otherList) {
        SortedDoublyLinkedList<T> merged = this;
        for (T obj : otherList) {
            merged.add(obj);
        }

        return merged;
    }

    public boolean isPrefix(SortedDoublyLinkedList<? extends T> otherList) {
        if (this.size() > otherList.size())
            return false;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).compareTo(otherList.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    public int indexOf(T obj) {
        int index = -1;
        for (T element : this) {
            if (element.equals(obj)) {
                return ++index;
            }
            else
                index ++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode.next() != null;
            }

            @Override
            public T next() {
                currentNode = currentNode.next();
                return currentNode.getData();
            }
        };
    }
}
