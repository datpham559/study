package com.example.study.todo;

public class let706 {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        System.out.println("result: " + myHashMap);
    }
}
class Node{
    int k;
    int v;
    Node next;
    public Node(int k, int v) {
        this.k = k;
        this.v = v;
    }

    public Node(int k, int v, Node next) {
        this.k = k;
        this.v = v;
        this.next = next;
    }

    public Node(){

    }
}
class MyHashMap {
    Node node;
    int size;
    public MyHashMap() {
        node = new Node();
        size = 1;
    }

    public void put(int key, int value) {
        if (size == 0) {
            node = new Node(key,value,null);
        }
        while (node.next == null) {
            node.next = new Node(key,value,null);
            size++;
        }
    }

    public int get(int key) {
        Node current = node;
        while (current != null) {
            if(current.k == key) {
                return current.v;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        if (size == 1 && node.k == key) {
            node = null;
            size--;
        } else {
            Node current = node.next;
            while (current != null) {
                Node prev = node;
                if(current.k == key) {
                    prev.next = current.next;
                    size--;
                }
                current = node.next;
            }
        }

    }
}
