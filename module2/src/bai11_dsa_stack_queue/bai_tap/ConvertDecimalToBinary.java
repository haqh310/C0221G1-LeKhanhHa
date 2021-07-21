package bai11_dsa_stack_queue.bai_tap;

import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        float number =  9;
        Stack stack = new Stack();
        while (number > 0){
            stack.push(number % 2);
            number = number /2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
