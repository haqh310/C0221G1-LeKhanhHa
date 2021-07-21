package bai11_dsa_stack_queue.bai_tap;

import java.util.*;

public class StringPalindrome {
    public static void main(String[] args) {
        String[] str = "Able was I ere I saw Elba".split("");
        Stack<String> stack = new Stack<String>();
        Queue<String> queue = new LinkedList<>();
        for(String s: str){
            stack.push(s.toLowerCase());
            queue.add(s.toLowerCase());
        }
        while (!stack.isEmpty()) {
            boolean check = stack.pop().equals(queue.poll());
            if (!check) {
                System.out.println("No is a string Palindrome");
                System.exit(0);
            }
        }
        System.out.println("Is a string Palindrome");
    }
}
