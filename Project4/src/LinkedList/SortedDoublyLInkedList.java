package LinkedList;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by David on 11/21/2016.
 */
public class SortedDoublyLInkedList<T extends Comparable<T>> implements Serializable, Iterable<T> {
    private int     size = 0;
    private Node<T> head = null;

    public boolean add(T obj) {
        if (obj == null) {
            return false;
        } else if (isEmpty()) {
            head = new Node<T>(obj);
            size ++;
            return true;
        } else {
            Node<T> node = new Node<T>(obj);

            for (T element : this) {
                // I use an if block here instead of a switch statement because the Comparable interface states that
                // compareTo() may return values greater than or less than 0, not necessarily 1 or -1.
                int comparison = element.compareTo(obj);
                if (comparison == 0) {
                    return false;
                } else if (comparison > 0) {

                } else if (comparison < 0) {
                    continue;
                }
                return false;
            }
            node.setPrev(head);
            head.setNext(node);
            head = node;
            return true;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    private void printList() {

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode.getNext() != null;
            }

            @Override
            public T next() {
                currentNode = currentNode.getNext();
                return currentNode.getData();
            }
        };
    }
}
