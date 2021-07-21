package bai10_dsa_danh_sach.bai_tap.trien_khai_arraylist;

import java.util.ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(5);
        listInteger.add(6);
        listInteger.add(7);
        listInteger.add(2,3);
        for (int i = 0; i < listInteger.size(); i++) {
            System.out.println(listInteger.get(i));
        }
    }
}
