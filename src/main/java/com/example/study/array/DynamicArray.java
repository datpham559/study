package com.example.study.array;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
    private T[] arr;
    private int size;
    private int capacity;

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    public void set(int index, T element) {
        arr[index] = element;
    }

    public void add(T element) {
        if (size == capacity - 1) {
            if (capacity == 0) { // phải check TH này nếu ko 0 * 2 vẫn = 0 :)))
                capacity = 1;
            } else {
                capacity *= 2;
            }
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
        arr[size++] = element;
    }

    public void removeAt(int removeIndex) {
        if (removeIndex < 0 || removeIndex >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + removeIndex);
        if (size < capacity / 2)
            capacity /= 2;
        T[] newArray = (T[]) new Object[capacity]; // cách này mỗi lần remove đều tạo ra object mới ?
        int count = 0;
        arr[removeIndex] = null;
        for (int i = 0; i < size; i++) {
            if (i != removeIndex) {
                newArray[count] = arr[i];
                count++;
            }
        }
        arr = newArray;
        size--;
    }

    public void removeAtPerformance(int removeIndex) {
        if (removeIndex < 0 || removeIndex >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + removeIndex);
        arr[removeIndex] = null;
        for (int i = removeIndex; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;

        if (size < capacity / 2) {
            capacity /= 2;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
    }

    public void remove(Object object) {
        int index = indexOf(object);
//        if (index == -1){
//            throw new IndexOutOfBoundsException("Object not found: " + object); không cần check vì removeAt đã check rồi
//        }
        removeAt(index);
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == null) {
                if (object == null) return i;
            } else if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder(size);
            sb.append("[");
            for (int i = 0; i < size - 1; i++) {
                sb.append(arr[i]).append(",");
            }
            sb.append(arr[size - 1]).append("]");
            return sb.toString();
        }
    }
}
