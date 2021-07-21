package bai10_dsa_danh_sach.bai_tap.trien_khai_arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
        size = capacity;
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            ensureCapacity(10);
        }
        if (size <= index) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        size++;
        for (int i = index; i < size; i++) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
    }

    public E remove(int index) {
        if (size <= index) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        E removeElement = (E) elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return removeElement;
    }

    public int size() {
        return size;
    }

    public E clone() {
        return (E) Arrays.copyOf(elements, size);
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity(10);
        }
        elements[size++] = e;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        int newSize = elements.length + minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public void clear() {
        size = 0;
        //elements = new Object[DEFAULT_CAPACITY];
    }
}
