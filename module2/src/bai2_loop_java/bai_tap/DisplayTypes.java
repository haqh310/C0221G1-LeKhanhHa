package bai2_loop_java.bai_tap;

import java.util.Scanner;

public class DisplayTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Draw the rectangle");
        System.out.println("2. Draw the square triangle");
        System.out.println("3. Draw the isosceles triangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1 :
                for(int i=0;i<5;i++){
                    for(int j=0;j<7;j++){
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                break;
            case 2:
                for(int i=0; i<5; i++){
                    for(int j=0; j<=i; j++){
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                break;
            case 3:
                for(int i=0;i<5;i++){
                    for(int j=0;j<4-i;j++){
                        System.out.print(" ");
                    }
                    for(int j=0; j<i*2+1; j++){
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("No choice");

        }
    }
}
