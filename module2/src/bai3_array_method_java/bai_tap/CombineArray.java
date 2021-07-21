package bai3_array_method_java.bai_tap;

import java.util.Scanner;

public class CombineArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of array A: ");
        int lengthA = Integer.parseInt(scanner.nextLine());
        int[] arrayA = new int[lengthA];
        for (int i = 0; i <lengthA ; i++) {
            System.out.printf("Enter A[%d]: ",i);
            arrayA[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Enter length of array B: ");
        int lengthB = Integer.parseInt(scanner.nextLine());
        int[] arrayB= new int[lengthB];
        for (int i = 0; i <lengthB ; i++) {
            System.out.printf("Enter B[%d]: ",i);
            arrayB[i] = Integer.parseInt(scanner.nextLine());
        }
        int[] arrayC = new int[lengthA+lengthB];
        for (int i = 0; i <lengthA ; i++) {
            arrayC[i] = arrayA[i];
        }
        for(int i=0;i<lengthB;i++){
            int index = lengthA+i;
            arrayC[index] = arrayB[i];
        }
        System.out.print("Elements of array C: ");
        for(int element : arrayC){
            System.out.print(element+"\t");
        }
    }
}
