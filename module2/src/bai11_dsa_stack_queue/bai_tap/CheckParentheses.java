package bai11_dsa_stack_queue.bai_tap;

import java.util.Stack;

public class CheckParentheses {
    public static void main(String[] args) {
        String[] str = "s * (s – a) * (s – b) * (s – c) ".split("");
        Stack<String> bStack = new Stack<>();
        for (String s : str) {
            if (s.equals("(")) {
                bStack.push(s);
            }
            if (s.equals(")")) {
                if(bStack.isEmpty()){
                    System.out.println(false);
                    System.exit(0);
                }
                bStack.pop();
            }
        }
        if(bStack.isEmpty()){
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}
