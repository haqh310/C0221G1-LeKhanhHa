package bai11_dsa_stack_queue.bai_tap;

import java.util.Stack;

public class ReversedElementInArray {
    public static void reversesIntegerArray(){
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);
        int[] arr = new int[5];
        System.out.print("Array before: ");
        for (int element:integerStack  ) {
            System.out.print(element+" ");
        }
       for(int i=0;i<5;i++){
            arr[i] = integerStack.pop();
       }
        System.out.print("\nArray after: ");
        for (int element:arr  ) {
            System.out.print(element+" ");
        }
    }
    public static void reversesStringArray(){
        Stack<String> wStack = new Stack<>();
        String[] str = "adcdef".split("");
        System.out.print("\nString before: ");
        for (String s:str) {
            wStack.push(s);
            System.out.print(s);
        }
        for(int i=0; i<str.length;i++){
            str[i] = wStack.pop();
        }
        System.out.print("\nString after: ");
        for (String s:str) {
            System.out.print(s);;
        }
    }
    public static void main(String[] args) {
        reversesIntegerArray();
        reversesStringArray();
    }
}
