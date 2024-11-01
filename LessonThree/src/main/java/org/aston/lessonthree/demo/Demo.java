package org.aston.lessonthree.demo;

import org.aston.lessonthree.demo.entity.Animal;
import org.aston.lessonthree.demo.entity.Dog;
import org.aston.lessonthree.demo.entity.Cat;
import org.aston.lessonthree.myList.MyArrayList;
import org.aston.lessonthree.myList.MyLinkedList;
import org.aston.lessonthree.myList.MyList;
import org.aston.lessonthree.myList.util.MySort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    private static final Animal[] DEFAULT_ELEMENTS = {
            new Cat(4),
            new Animal(1),
            new Animal(3),
            new Dog(2)
    };

    public void tests() {
        System.out.println("MyLinkedList test:");
        linkedListDemo();
        System.out.println("MyArrayList test:");
        arrayListDemo();
        System.out.println("sort test:");
        sortTest();
        System.out.println("Tests end");
    }

    private void linkedListDemo() {
        myListSimpleTests(new MyLinkedList<>());
        sortTest(new MyLinkedList<>());
    }

    private void arrayListDemo() {
        myListSimpleTests(new MyArrayList<>());
        sortTest(new MyArrayList<>());
    }
    private void myListSimpleTests(MyList<Animal> list) {
        System.out.println(list);

        list.add(new Animal(1));
        System.out.println(list);

        list.add(new Cat(2));
        System.out.println(list);

        System.out.println("add Collection.of(D(3),D(4),D(5))");
        List<Dog> listToAdd = new ArrayList<>(Arrays.asList(
                new Dog(3),
                new Dog(4),
                new Dog(5)
        ));
        list.addAll(listToAdd);
        System.out.println(list);

        System.out.println("remove Cat(2)");
        list.remove(new Cat(2));
        System.out.println(list);

        System.out.println("remove by index = 1");
        list.remove(1);
        System.out.println(list);
    }

    private void sortTest(MyList<Object> list) {
        System.out.println("sort test:");
        List<Integer> collection = new ArrayList<>(Arrays.asList(1, 9, 3, 7, 5, 3));
        list.addAll(collection);
        System.out.println("before:" + list);

        list.sort();
        System.out.println("after:" + list);

        System.out.println("add 3 elements, remove 2 with index = 2");
        list.addAll(new Integer[]{4, 3, 2});
        list.remove(2);
        list.remove(2);
        System.out.println(list);

        list.sort();
        System.out.println(list);
    }

    private void sortTest() {
        System.out.println("Collection sort:");
        Collection<Animal> cm = new LinkedList<>(Arrays.asList(DEFAULT_ELEMENTS));

        System.out.println("before:");
        System.out.println(cm);

        System.out.println("with Comparator:");
        MySort.sort(cm, Comparator.comparingInt(Animal::getValue));
        System.out.println(cm);

        System.out.println("refresh");
        cm = new LinkedList<>(Arrays.asList(DEFAULT_ELEMENTS));
        System.out.println(cm);

        System.out.println("without Comparator:");
        MySort.sort(cm);
        System.out.println(cm);
    }
}
