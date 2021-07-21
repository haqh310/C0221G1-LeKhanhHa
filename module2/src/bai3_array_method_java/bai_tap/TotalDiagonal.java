package bai3_array_method_java.bai_tap;

import java.util.Scanner;

public class TotalDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number N: ");
        int n = Integer.parseInt(scanner.nextLine());
        int multiArray[][] = TotalAColumn.inputMultiArray(n,n);
        int total=0;
        for (int i = 0; i <n ; i++) {
            total += multiArray[i][i];
        }
        System.out.println("Total diagonal line of Array2Way: "+total);
    }
}
