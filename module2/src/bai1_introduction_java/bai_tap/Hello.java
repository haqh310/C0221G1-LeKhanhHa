package bai1_introduction_java.bai_tap;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.printf("bai1_Introduction_Java.bai_tap.Hello %s",name);
    }
}
