package bai1_introduction_java.bai_tap;

import java.util.Scanner;

public class ExchangeMoney {
    public static void main(String[] args) {
       final double VND = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input USD: ");
       double usd = Double.parseDouble(scanner.nextLine()) ;
        double vnd = usd * VND;
        System.out.printf("%.2f USD to %.2f VND",usd,vnd);
    }
}
