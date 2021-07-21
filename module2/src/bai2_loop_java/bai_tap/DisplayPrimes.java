package bai2_loop_java.bai_tap;

import java.util.Scanner;

public class DisplayPrimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int num=2;
       while (count<number){
           boolean check = isPrime(num);
           if(check){
               System.out.print(num+" ");
               count++;
           }
           num++;
       }
    }
    public static boolean isPrime(int number){
        boolean check =true;
        if(number<2){
            check=false;
        }
        else {
            for(int i=2;i<=Math.sqrt(number);i++){
                if(number % i == 0){
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
}
