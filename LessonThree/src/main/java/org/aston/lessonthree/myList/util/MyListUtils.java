package org.aston.lessonthree.myList.util;

public abstract class MyListUtils {
    public static void checkIndex(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
