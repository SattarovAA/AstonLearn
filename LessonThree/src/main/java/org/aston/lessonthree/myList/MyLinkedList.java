package org.aston.lessonthree.myList;

import org.aston.lessonthree.myList.util.MyListUtils;
import org.aston.lessonthree.myList.util.MySort;

import java.util.Arrays;
import java.util.Collection;
public class MyLinkedList<E> implements MyList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private boolean isSorted;

    public MyLinkedList() {
    }

    public MyLinkedList(Collection<? extends E> col) {
        this.addAll(col);
    }

    public MyLinkedList(E[] arr) {
        this.addAll(arr);
    }

    @Override
    public void add(E e) {
        final Node<E> newNode = new Node<>(last, e, null);

        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        isSorted = false;
    }

    @Override
    public boolean addAll(Collection<? extends E> col) {
        if (col == null || col.isEmpty()) {
            return false;
        }
        col.forEach(this::add);
        return true;
    }

    @Override
    public boolean addAll(E[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        Arrays.stream(arr).forEach(this::add);
        return true;
    }

    @Override
    public E get(int index) {
        MyListUtils.checkIndex(index, size);
        return getNode(index).item;
    }

    private Node<E> getNode(int index) {
        Node<E> node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++)
                node = node.next;
        } else {
            node = last;
            for (int i = size - 1; i > index; i--)
                node = node.prev;
        }
        return node;
    }

    @Override
    public boolean remove(E e) {
        if (e == null) {
            return false;
        }
        for (Node<E> node = first; node != null; node = node.next) {
            if (e.equals(node.item)) {
                unlink(node);
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(int index) {
        MyListUtils.checkIndex(index, size);
        Node<E> node = getNode(index);
        unlink(node);
    }

    private void unlink(Node<E> node) {
        final Node<E> next = node.next;
        final Node<E> prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] result = (E[]) new Object[size];
        int i = 0;
        for (Node<E> n = first; n != null; n = n.next) {
            result[i++] = n.item;
        }
        return result;
    }

    @Override
    public void sort() {
        if (isSorted) {
            return;
        }
        E[] elements = toArray();
        MySort.sort(elements);
        clear();
        addAll(elements);
        isSorted = true;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public boolean isSorted() {
        return isSorted;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MyLinkedList(elements=[");
        if (size == 0) {
            builder.append("], size=0");
            return builder.toString();
        }

        for (Node<E> node = first; node != null; node = node.next) {
            if (node != first) {
                builder.append(", ");
            }
            builder.append(node.item);
        }

        builder.append("], size=")
                .append(size)
                .append(", isSorted=")
                .append(isSorted)
                .append(")")
        ;
        return builder.toString();
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }
}
