package ss3_array_and_method_in_java.exercise;

import java.util.Scanner;

public class CountCharacterInString {
    //    Đếm số lần xuất hiện của ký tự trong chuỗi
    public static void main(String[] args) {
        String str = "Hello World";
        char character;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ký tự: ");
        character = scanner.nextLine().charAt(0);

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (character == str.charAt(i)) {
                count++;
            }
        }

        System.out.println("Ký tự " + character + " xuất hiện " + count + " lần trong chuỗi " + str);
    }
}
