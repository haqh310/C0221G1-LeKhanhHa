package bai1_introduction_java.thuc_hanh;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("b: ");
        double b =Double.parseDouble(scanner.nextLine());
        System.out.println("c: ");
        double c = Double.parseDouble(scanner.nextLine());

        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        } else {
            if (b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
