package bai3_array_method_java.bai_tap;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter index element need delete:");
        int index = Integer.parseInt(scanner.nextLine());
        deleteArray(arr,index);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
    public static void deleteArray(int[] arr,int index){
        for(int i=index-1;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1]=0;
    }
}
