package bai3_array_method_java.thuc_hanh;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);

        int[] array = new int[size];
         for(int i=0;i<size;i++){
            System.out.print("Enter element " + (i +1) + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int i = 0; i< array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        for(int i=0;i<size/2;i++){
            int temp = array[i];
            array[i]=array[size-i-1];
            array[size-i-1] = temp;
        }

        System.out.printf("%-20s%s","Reverse array: ", "");
        for(int i=0;i<size;i++){
            System.out.print(array[i] +"\t");
        }
    }
}
