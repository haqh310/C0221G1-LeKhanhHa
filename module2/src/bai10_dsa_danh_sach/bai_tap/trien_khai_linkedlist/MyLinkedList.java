package bai10_dsa_danh_sach.bai_tap.trien_khai_linkedlist;

import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {

    }

    public Node getHead() {
        return head;
    }

    public void add(int index, E e) {
        Node temp = head;
        Node holder;
        if(index ==0){
            head = new Node(e);
            return;
        }
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(e);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E e) {
        Node temp = head;
        int i = 0;
        while (i < numNodes - 1) {
            temp = temp.next;
            i++;
        }
        temp.next = new Node(e);
        numNodes++;
    }

    public E remove(int index) {
        Node temp = head;
        Node holder;
        int i = 0;
        if (index >= numNodes - 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + numNodes);
        }
        if (index == 0) {
            head = temp.next;
            return (E) temp.data;
        }
        while (i < index - 1) {
            i++;
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = temp.next.next;
        numNodes--;
        return (E) holder.data;
    }

    public boolean remove(Object e) {
        Node temp = head;
        if (temp.data == e) {
            head = head.next;
            return true;
        }
        while (temp != null) {
            if (temp.next == null) {
                return false;
            }
            if (temp.next.data == e) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
        return true;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        return this;
    }

    public boolean contains(E o) {
        Node temp = head;
        while (temp != null) {
            if (o == temp.data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E o) {
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (o == temp.data) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public boolean add(E e) {
        this.addLast(e);
        return true;
    }

    public E get(int i) {
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (i == index) {
                return (E) temp.data;
            }
            index++;
            temp = temp.next;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size " + numNodes);
    }

    public E getFirst() {
        return (E) head.data;
    }

    public E getLast() {
        Node temp = head;
        int index = 0;
        while (index < numNodes - 1) {
            index++;
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void clear() {
        numNodes = 0;
        Node temp = head;
        while (temp != null) {
            head = temp.next;
        }
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public Object getData() {
            return data;
        }
    }
}
