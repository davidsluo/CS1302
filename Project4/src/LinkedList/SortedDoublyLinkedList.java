package LinkedList;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by David on 11/21/2016.
 */
public class SortedDoublyLinkedList<T extends Comparable> implements Serializable, Iterable<T> {
    private int size = 0;
    private Node<T> head = null;


    public boolean add(T obj) {
        Node<T> cursor = head;
        Node<T> node = new Node<T>(obj);

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
                    head = node;
                }

                cursor.setPrev(node);
                size++;
                return true;

            }
//            else if (comparison < 0) {
//                // do nothing?
//            }

            if (cursor.hasNext()) {
                cursor = cursor.next();
            } else
                break;
        }

        if (cursor != null) {
            cursor.setNext(node);
            node.setPrev(cursor);
        } else {
            head = node;
        }
        size++;
        return true;

    }

    public boolean remove(T obj) {
        Node<T> cursor = head;
        if (cursor == null)
            return false;
        while (cursor != null) {
            if (cursor.getData().equals(obj)) {
                if (cursor.hasPrev()) {
                    cursor.prev().setNext(cursor.next());
                } else {
                    head = cursor.next();
                }
                if (cursor.hasNext()) {
                    cursor.next().setPrev(cursor.prev());
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
        Node<T> cursor = head;
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

    public void printList() {
        for (T obj : this) {
            System.out.println(obj.toString());
        }
    }

    public SortedDoublyLinkedList merge(SortedDoublyLinkedList<?> otherList) {
        SortedDoublyLinkedList merged = this;
        for (Object obj : otherList) {
            merged.add((Comparable) obj);
        }

        return merged;
    }

    /**
     * Is this list a prefix of otherList?
     *
     * @param otherList the list that this list might be a prefix of
     * @return if this list is a prefix of otherList
     */
    public boolean isPrefix(SortedDoublyLinkedList otherList) {
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
            } else
                index++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> cursor = null;

            @Override
            public boolean hasNext() {
                if (cursor == null)
                    return head != null && head.next() != null;
                else
                    return cursor.next() != null;
            }

            @Override
            public T next() {
                if (cursor == null) {
                    cursor = head;
                    return cursor.getData();
                } else {
                    cursor = cursor.next();
                    return cursor.getData();
                }
            }
        };
    }
}
