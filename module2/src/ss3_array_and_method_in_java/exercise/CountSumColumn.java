package ss3_array_and_method_in_java.exercise;

import java.util.Scanner;

public class CountSumColumn {
    //    Tính tổng các số ở một cột xác định
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        int sum = 0;

//        Nhập cột muốn tính
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập cột muốn tính: ");
        int index_col = scanner.nextInt();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == index_col) {
                    sum = sum + arr[i][index_col];
                    System.out.print(arr[i][index_col] + "\t");
                }
            }
        }
        System.out.println();
        System.out.println("Tổng các số trong cột " + index_col + " là: " + sum);
    }
}
