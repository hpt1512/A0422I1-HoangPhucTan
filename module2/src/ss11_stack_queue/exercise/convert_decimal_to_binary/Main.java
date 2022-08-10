package ss11_stack_queue.exercise.convert_decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        while (number > 0) {
            int surplus = number % 2;
            number = number / 2;
//            System.out.print(surplus + "\t");
            integerStack.push(surplus);
        }
        System.out.println("Binary number: ");
        while (!integerStack.isEmpty()) {
            System.out.print(integerStack.pop());
        }

    }
}
