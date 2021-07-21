package bai13_thuat_toan_tim_kiem.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class FindConsecutiveString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Enter a string: ");
        String string = input.nextLine();
        for (int i = 0; i < string.length(); i++) { 		// single loop

            if (list.size() > 1 && string.charAt(i) <= list.getLast() &&
                    list.contains(string.charAt(i))) {
                list.clear(); // Simple statement
            }

            list.add(string.charAt(i)); // Simple statement

            if (list.size() > max.size()) { // Simple statement
                max.clear();
                max.addAll(list);
            }
        }

        for (Character ch: max) { // single loop
            System.out.print(ch); // Simple statement
        }
        System.out.println();
    }
}
