package ss3_array_and_method_in_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinElement {
    //    Tìm giá trị nhỏ nhất trong mảng
    public static void main(String[] args) {
        int size;
        int[] arr;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập độ dài của mảng: ");
            size = scanner.nextInt();

            if (size < 0 || size > 20) {
                System.out.println("Độ dài mảng lớn hơn 0 và không quá 20 phần tử, xin nhập lại");
            }
        } while (size < 0 || size > 20);

        arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " : ");
            arr[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(arr));

        int min = FindMin(arr);
        System.out.println("Giá trị nhỏ nhất trong mảng là: " + min);
    }

    public static int FindMin(int[] arr) {
        int min = arr[0];
        for (int item : arr) {
            if (item < min) {
                min = item;
            }
        }
        return min;
    }
}
