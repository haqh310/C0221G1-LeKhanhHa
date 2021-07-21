package bai4_oop_java.bai_tap.xay_dung_lop_quadratic_equation;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter c: ");
        double c = Double.parseDouble(scanner.nextLine());
        QuadraticEquation quad = new QuadraticEquation(a,b,c);
        System.out.printf("Solution of equation %.2fx2 + %.2fx + %.2f = 0 is: %.2f and %.2f",a,b,c,quad.getRoot1(),quad.getRoot2());
    }
}
