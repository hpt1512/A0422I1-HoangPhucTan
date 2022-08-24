package ss15_exception_debug.exercise.illegal_triangle_exception;

import java.util.Scanner;

public class Main {

    public static boolean checkTringle(int a, int b, int c) throws IllegalTriangleException {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        } else {
            throw new IllegalTriangleException("Nhập lỗi");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cạnh a: ");
        int a = scanner.nextInt();
        System.out.println("Nhập cạnh b: ");
        int b = scanner.nextInt();
        System.out.println("Nhập cạnh c: ");
        int c = scanner.nextInt();

        try {
            if (checkTringle(a, b, c)) {
                System.out.println("Chu vi: " + (a + b + c));
            }
        } catch (IllegalTriangleException e) {
            System.err.println(e.getMessage());
        } finally {
//            System.out.println("Finally");
        }
    }
}
