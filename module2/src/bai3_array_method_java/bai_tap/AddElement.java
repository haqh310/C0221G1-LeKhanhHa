package bai3_array_method_java.bai_tap;

import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter X: ");
        int numX = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter position to add : ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index <= 1 || index >= arr.length - 1) {
            System.out.printf("No add %d in array at index %d", numX, index);
        } else {
            addArr(arr, numX, index);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
        }
    }

    public static void addArr(int[] arr, int x, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
        arr[index] = x;
    }
}
