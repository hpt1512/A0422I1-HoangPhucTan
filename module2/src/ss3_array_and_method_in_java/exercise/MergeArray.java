package ss3_array_and_method_in_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    //    Gộp mảng
    public static void main(String[] args) {
        int sizeArr1;
        int sizeArr2;
        Scanner scanner = new Scanner(System.in);

//        Nhập mảng 1
        System.out.print("Nhập độ dài mảng 1: ");
        sizeArr1 = scanner.nextInt();

        int[] arr1 = new int[sizeArr1];

        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Nhập mảng 1 - Nhập phần tử thứ " + (i + 1) + " : ");
            arr1[i] = scanner.nextInt();
        }

        System.out.println("-----Mảng 1: "+Arrays.toString(arr1));

//        Nhập mảng 2
        System.out.print("Nhập độ dài mảng 2: ");
        sizeArr2 = scanner.nextInt();

        int[] arr2 = new int[sizeArr2];

        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Nhập mảng 2 - Nhập phần tử thứ " + (i + 1) + " : ");
            arr2[i] = scanner.nextInt();
        }

        System.out.println("-----Mảng 2: "+Arrays.toString(arr2));

//        Gộp mảng
        int[] arr3 = new int[sizeArr1 + sizeArr2];

        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (i == j) {
                    arr3[i] = arr1[j];
                }
            }
        }

        int index = 0;
        for (int i = arr1.length; i < arr3.length; i++) {
            arr3[i] = arr2[index];
            index++;
        }

        System.out.println("-----Mảng sau khi gộp: "+Arrays.toString(arr3));

    }
}
