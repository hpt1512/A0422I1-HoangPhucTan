package ss11_stack_queue.exercise.check_bracket;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập biểu thức: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        if (checkBracket(inputString)) {
            System.out.println("WELL");
        } else {
            System.out.println("NO WELL");
        }
    }

    public static boolean checkBracket(String inputString) {
        Stack<String> bracketRightStack = new Stack<>();
        Stack<String> bracketLeftStack = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == 40) {
                bracketRightStack.push(Character.toString(inputString.charAt(i)));
            }
            if (inputString.charAt(i) == 41) {
                bracketLeftStack.push(Character.toString(inputString.charAt(i)));
            }
        }

        return bracketLeftStack.size() == bracketRightStack.size();

    }
}
