package ss11_stack_queue.exercise.reverse;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);

        while (!integerStack.isEmpty()){
            System.out.println(integerStack.pop());
        }
    }
}
