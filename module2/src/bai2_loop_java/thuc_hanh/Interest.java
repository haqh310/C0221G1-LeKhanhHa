package bai2_loop_java.thuc_hanh;

import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        double money =  Double.parseDouble(scanner.nextLine());
        System.out.println("Enter number of months: ");
        byte month = Byte.parseByte(scanner.nextLine());
        System.out.println("Enter annual interest rate in percentage : ");
        float interest_rate = Float.parseFloat(scanner.nextLine());
        double total_interest = 0;
        for(int i=0;i<month;i++){
            total_interest += money*(interest_rate/100)/12*month;
        }
        System.out.println("Total of interest: " + total_interest);
    }
}
