package bai1_introduction_java.thuc_hanh;

import java.util.Scanner;

public class Operators {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter height: ");
        height = Float.parseFloat(scanner.nextLine());
        float area = width * height;
        System.out.println("Area is: " + area);
    }
}
