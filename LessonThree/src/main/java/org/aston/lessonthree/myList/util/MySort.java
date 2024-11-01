package org.aston.lessonthree.myList.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public abstract class MySort {

    @SuppressWarnings("unchecked")
    public static <T> void sort(Collection<T> col, Comparator<? super T> com) {
        Object[] arr = col.toArray();
        mergeSort((T[]) arr, com);
        fill(col, arr);
    }

    public static <T extends Comparable<? super T>> void sort(Collection<T> col) {
        Object[] arr = col.toArray();
        mergeSort(arr);
        fill(col, arr);
    }

    @SuppressWarnings("unchecked")
    private static <T> void fill(Collection<T> col, Object[] arr) {
        col.clear();
        Collections.addAll(col, (T[]) arr);
    }

    public static void sort(Object[] a) {
        mergeSort(a);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void mergeSort(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 &&
                    ((Comparable) arr[j - 1]).compareTo(arr[j]) > 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static <T> void mergeSort(T[] arr, Comparator<T> c) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 &&
                    c.compare(arr[j - 1], arr[j]) > 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 &&
                    arr[j - 1].compareTo(arr[j]) > 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
