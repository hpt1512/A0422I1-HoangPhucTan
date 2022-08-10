package ss11_stack_queue.exercise.reverse;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stackIntegers = new Stack<>();
        ArrayList<Integer> integerArrayList;
        int count;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử trong mảng: ");
        count = scanner.nextInt();

        integerArrayList = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " : ");
            int item = scanner.nextInt();
            integerArrayList.add(item);
        }

        System.out.println("In arraylist: ");
        for (int item : integerArrayList) {
            System.out.print(item + "\t");
        }

        for (int i = 0; i < count; i++) {
            stackIntegers.push(integerArrayList.get(i));
        }

        System.out.println();
        System.out.println("In stack: ");
        for (int item : stackIntegers) {
            System.out.print(item + "\t");
        }

        integerArrayList.clear();

        for (int i = count - 1; i >= 0; i--) {
            for (int j = stackIntegers.size() - 1; j >= 0; j--) {
                if (i == j) {
                    integerArrayList.add(stackIntegers.get(j));
                }
            }
        }

        System.out.println();
        System.out.println("In arraylist after reverse: ");
        for (int item : integerArrayList) {
            System.out.print(item + "\t");
        }

    }
}
