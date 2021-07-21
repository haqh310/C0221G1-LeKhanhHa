package bai10_dsa_danh_sach.bai_tap.trien_khai_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(6);
        linkedList.addFirst(5);
        linkedList.addFirst(4);
        linkedList.addFirst(3);
        linkedList.addLast(7);
        linkedList.addLast(8);
        linkedList.addLast(9);
//        MyLinkedList<Integer> link = linkedList.clone();
        linkedList.remove((Object) 5);
        linkedList.printList();
//        LinkedList<Integer> link = new LinkedList<>();
//        link.add(5);

    }
}
