package bai2_loop_java.thuc_hanh;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = Integer.parseInt(scanner.nextLine());
        boolean check = true;
        if(number<2){
            check=false;
        }
        else {
            for(int i=2;i<=Math.sqrt(number);i++){
                if(number % i ==0){
                    check=false;
                    break;
                }
            }
        }
        if(check){
            System.out.printf("%d is a Prime",number);
        }
        else {
            System.out.printf("%d is not a Prime",number);
        }

    }
}
