package bai3_array_method_java.bai_tap;

import java.util.Scanner;

public class TotalAColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number m: ");
        int m= Integer.parseInt(scanner.nextLine());
        System.out.print("Enter a number n: ");
        int n= Integer.parseInt(scanner.nextLine());
        int[][] multiArray = inputMultiArray(m,n) ;
        System.out.print("Enter index column: ");
        int column= Integer.parseInt(scanner.nextLine());
        if(column<0 || column > n-1){
            System.out.printf("Nothing column %d in Array2Way",column);
            System.exit(0);
        }
        int total=0;
        for (int i = 0; i <m ; i++) {
            total+=multiArray[i][column];
        }
        System.out.printf("Total column %d of multiArray: %d",column,total);
    }
    public static int[][] inputMultiArray(int m,int n){
        int[][] multiArray= new int[m][n];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.printf("Enter Array[%d][%d]= ",i,j);
                multiArray[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        for (int[] arr : multiArray ) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+"\t");
            }
            System.out.println("");
        }
        return multiArray;
    }
}
