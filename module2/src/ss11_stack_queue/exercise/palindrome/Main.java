package ss11_stack_queue.exercise.palindrome;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<String> stringQueue = new ArrayDeque<>();
        Stack<String> stringStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String str = scanner.nextLine();

//        String[] arrayString = str.toLowerCase().split(" ");
//        System.out.println(Arrays.toString(arrayString));

        for (int i = 0; i < str.length(); i++) {
            stringStack.push(Character.toString(str.charAt(i)));
            stringQueue.add(Character.toString(str.charAt(i)));
        }
        String checkStackString = "";
        String checkQueueString = "";

        while (!stringStack.isEmpty()) {
            checkStackString = checkStackString + stringStack.pop();
        }
        System.out.println();

        while (!stringQueue.isEmpty()) {
            checkQueueString = checkQueueString + stringQueue.poll();
        }
        if (checkStackString.equals(checkQueueString))
            System.out.println("Đây là chuỗi đối xứng.");
        else
            System.out.println("Đây không phải là chuỗi đối xứng.");

    }
}
