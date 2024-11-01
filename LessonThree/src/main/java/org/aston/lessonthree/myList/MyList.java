package org.aston.lessonthree.myList;

import java.util.Collection;

public interface MyList<E> {
    void add(E e);

    boolean addAll(Collection<? extends E> c);

    boolean addAll(E[] a);

    E get(int index);

    boolean remove(E e);

    void remove(int index);

    int size();

    E[] toArray();

    void sort();

    void clear();

    boolean isSorted();
}
