package com.example.study.linkedlist;

import java.util.Iterator;

public class DoublyLinkedListImpl<T> implements DoublyLinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> nextNode = current.getNext();
            current.setNext(null);
            current.setData(null);
            current.setPrev(null);
            current = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(T element) {
//        if (head == null) {
//            head = new Node<>(element, null, null);
//        } else {
//            Node<T> currentNode = head;
//            while (currentNode.getNext() != null) {
//                Node<T> nextNode = currentNode.getNext();
//                if (nextNode == null) {
//                    nextNode = new Node<>(element, null, currentNode);
//                }
//                currentNode.setNext(nextNode);
//            }
//        }
        addLast(element);
    }

    @Override
    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            Node<T> node = new Node<>(element, head, null);
            head.setPrev(node);
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            Node<T> node = new Node<>(element, null, tail);
            tail.setPrev(node);
        }
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty linked list!");
        return head.getData();
    }

    @Override
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty linked list!");
        return tail.getData();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty linked list!");
        T data = head.getData();
        head = head.getNext();
        size--;
        if (isEmpty()) tail = null;
        else head.setPrev(null);
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty linked list!");
        T data = tail.getData();
        tail = tail.getPrev();
        size--;
        if (isEmpty()) head = null;
        else tail.setNext(null);
        return null;
    }

    @Override
    public T remove(Node<T> node) {
        if (isEmpty()) throw new RuntimeException("Empty linked list!");
        if (node.getNext() == null) return removeLast();
        if (node.getPrev() == null) return removeFirst();

        Node<T> prevNode = node.getPrev();
        Node<T> nextNode = node.getNext();

        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;
        T data = node.getData();
        node.setData(null);
        node.setPrev(null);
        node.setNext(null);
        node = null;

        return data;
    }

    @Override
    public boolean remove(Object object) {
        Node<T> currentNode = head;

        if (object == null) {
            while (currentNode != null) {
                if (currentNode.getData() == null) {
                    remove(currentNode);
                    return true;
                }
                currentNode = currentNode.getNext();
            }
        } else {
            while (currentNode != null) {
                if (currentNode.getData().equals(object)) {
                    remove(currentNode);
                    return true;
                }
                currentNode = currentNode.getNext();
            }
        }
        return false;
    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();

//        Node<T> currentNode = head;
//        int count = 0;
//        while (current.getNext() != null) {
//            if (count == index) {
//                T data = current.getData();
//                remove(current);
//                return data;
//            }
//            current = current.getNext();
//            count++;
//        }
        // về bản chất làm như này không sai,nhưng sẽ bị O(n) => tính xem index đang ở bên trái hay bên phải so với mid, từ đó set currentNode là head hay tail
        Node<T> currentNode ;
        int count;
        if (index < size / 2) {
            count = 0;
            currentNode = head;
            while (currentNode != null) {
                if(index == count) {
                    remove(currentNode);
                    return currentNode.getData();
                }
                currentNode = currentNode.getNext();
                count++;
            }
        } else {
            count = size - 1;
            currentNode = tail;
            while (currentNode != null) {
                if(index == count) {
                    remove(currentNode);
                    return currentNode.getData();
                }
                currentNode = currentNode.getPrev();
                count--;
            }
        }
        return null;
    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
