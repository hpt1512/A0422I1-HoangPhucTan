package ss3_array_and_method_in_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class InsertElementInArray {
    //    Thêm phần tử vào mảng
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size, i, index;
        int[] array;
        do {
            System.out.println("Nhập vào số phần tử của mảng: ");
            size = scanner.nextInt();
        } while (size <= 0);

        array = new int[size];

        System.out.println("Nhập các phần tử cho mảng: ");
        for (i = 0; i < size; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Nhập số nguyên k: ");
        int k = scanner.nextInt();
        do {
            System.out.println("Nhập vị trí cần chèn : ");
            index = scanner.nextInt();
            if (index <= 1 || index >= size - 1) {
                System.out.println("Nhập sai nhập lại:");
            }
        } while (index <= 1 || index >= size - 1);

        array[size - 1] = array[index];
        for (i = 0; i < size; i++) {
            if (index == i) {
                array[i] = k;
            }
        }
        System.out.println("Mảng còn lại sau khi thêm phần tử " + k + " vào vị trí thứ " + index + " là: ");
        for (i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
