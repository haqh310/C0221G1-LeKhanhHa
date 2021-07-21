package bai1_introduction_java.bai_tap;

import java.util.Scanner;

public class ReadNumber {
    public static String[] arrayLess20 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static String[] arrayMore20 = {"twenty", "thirty", "forty", "fifty", "sixties", "seventies", "eighty", "ninety"};
    public static String[] arrayMore100 = {"", "thousand", "million"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number: ");
        int numberInput = Integer.parseInt(scanner.nextLine());
        int number = numberInput;
        int[] arrNum = new int[9];
        int size = 0;
        while (number > 0) {
            int num = number % 10;
            number /= 10;
            arrNum[size] = num;
            size++;
        }
        String[] result = new String[size / 3 + 1];
        for (int i = 0; i < size; i += 3) {
            int j = i / 3;
            result[j] = numLess999(arrNum[i], arrNum[i + 1], arrNum[i + 2]) + " ";
            result[j] += arrayMore100[j];
        }
        System.out.printf("%d read is ", numberInput);
        for (int j = size / 3; j > -1; j--) {
            if (result[j] != null) {
                System.out.print(result[j] + " ");
            }
        }
    }

    public static String numLess999(int a, int b, int c) {
        String result = "";
        int num20 = a + b * 10;
        int num100 = a + b * 10 + c * 100;
        if (num100 < 100) {
            if (num20 < 20) {
                result = arrayLess20[num20];
            } else {
                result = arrayMore20[b - 2] + arrayLess20[a];
            }
        } else {
            result = arrayLess20[c] + " hundred ";
            if (num20 < 20 && num20 > 0) {
                result += arrayLess20[num20];
            } else if (num100 % 100 != 0) {
                result += arrayMore20[b - 2] + " " + arrayLess20[a];
            }
        }
        return result;
    }
}


