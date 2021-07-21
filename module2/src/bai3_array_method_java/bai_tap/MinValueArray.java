package bai3_array_method_java.bai_tap;

import bai3_array_method_java.thuc_hanh.FindMinValueInArr;

import java.util.Scanner;

public class MinValueArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of Array: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] array = new int[size];
        for (int i = 0; i <size ; i++) {
            System.out.printf("Enter array[%d]: ",i);
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        int index = FindMinValueInArr.minIndex(array);
        System.out.println("Value min of Array is: " + array[index]);
    }
}
