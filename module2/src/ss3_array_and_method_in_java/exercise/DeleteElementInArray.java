package ss3_array_and_method_in_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElementInArray {
    //    Xoá phần tử khỏi mảng
    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 6};
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
        System.out.println(Arrays.toString(arr));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập phần tử cần xoá: ");
        int item_del = scanner.nextInt();
        int index_del;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item_del) {
                index_del = i;
                for (int j = index_del; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
//                    System.out.println(arr[j]);
                }
            }
        }
        arr[arr.length - 1] = 0;
        System.out.println(Arrays.toString(arr));
    }
}
