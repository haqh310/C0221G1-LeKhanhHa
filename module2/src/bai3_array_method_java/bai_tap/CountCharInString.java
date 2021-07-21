package bai3_array_method_java.bai_tap;

import java.util.Scanner;

public class CountCharInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter a char need find: ");
        char c = scanner.nextLine().charAt(0);
        int count =0;
        for (int i=0;i<str.length();i++) {
            if(str.charAt(i) == c){
                count++;
            }
        }
        System.out.printf("Amount char %s in string %s is %d",c,str,count);
    }


}
