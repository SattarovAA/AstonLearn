package org.aston.lessonthree.myList;

import lombok.ToString;
import org.aston.lessonthree.myList.util.MyListUtils;
import org.aston.lessonthree.myList.util.MySort;

import java.util.Arrays;
import java.util.Collection;

@ToString
public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTS = {};
    private Object[] elements;
    private int size;
    private boolean isSorted;

    public MyArrayList() {
        elements = EMPTY_ELEMENTS;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elements = EMPTY_ELEMENTS;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public MyArrayList(Collection<? extends E> col) {
        this();
        this.addAll(col);
    }

    public MyArrayList(E[] arr) {
        this();
        this.addAll(arr);
    }

    @Override
    public void add(E e) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = e;
        size++;
        isSorted = false;
    }

    private Object[] grow() {
        return grow(elements.length + 1);
    }

    private Object[] grow(int minCapacity) {
        if (minCapacity > 0) {
            int newCapacity = getNewLength(minCapacity);
            return elements = Arrays.copyOf(elements, newCapacity);
        }
        return elements = new Object[DEFAULT_CAPACITY];
    }

    private int getNewLength(int minLength) {
        return minLength + (minLength >> 1);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean addAll(Collection<? extends E> col) {
        if (col == null) {
            return false;
        }

        E[] a = (E[]) col.toArray();
        return addAll(a);
    }

    @Override
    public boolean addAll(E[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int newLength = arr.length + size;
        if (newLength >= elements.length) {
            grow(newLength);
        }
        System.arraycopy(arr, 0, elements, size, arr.length);
        size = newLength;
        isSorted = false;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        MyListUtils.checkIndex(index, size);
        return (E) elements[index];
    }


    @Override
    public boolean remove(E e) {
        int index = getElementsIndex(e);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    private int getElementsIndex(E e) {
        if (e == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        MyListUtils.checkIndex(index, size);
        size--;
        if (size > index) {
            System.arraycopy(elements, index + 1,
                    elements, index, size - index
            );
        }
        elements[size] = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        return (E[]) elements;
    }

    @Override
    public void sort() {
        if (isSorted) {
            return;
        }
        Object[] elementsToSort = Arrays.copyOf(elements, size);
        MySort.sort(elementsToSort);
        elements = elementsToSort;
        isSorted = true;
    }

    @Override
    public void clear() {
        elements = EMPTY_ELEMENTS;
        size = 0;
    }

    @Override
    public boolean isSorted() {
        return isSorted;
    }
}
