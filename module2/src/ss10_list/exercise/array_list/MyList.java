package ss10_list.exercise.array_list;

import java.util.Arrays;

public class MyList <E>{
    private int size = 0;
    public static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {

    }
    public MyList(int capacity) {
        this.size = capacity;
        elements = new Object[capacity];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public void set(int i, E element) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        elements[i] = element;
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            ensureCapa();
        }
        Object temp;
        temp = elements[index];
        elements[index] = element;
        System.out.println(elements.length);
        for (int i = index + 1; i < elements.length - 1; i++) {
            temp = elements[i];
            elements[i + 1] = temp;
        }
    }

    public void showArrayList() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(elements[i] + "\t");
        }
    }
}
