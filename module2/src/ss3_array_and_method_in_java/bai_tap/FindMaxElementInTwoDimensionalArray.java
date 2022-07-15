package ss3_array_and_method_in_java.bai_tap;

public class FindMaxElementInTwoDimensionalArray {
    //    Tìm phần tử lớn nhất trong mảng 2 chiều
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("Max = " + max);

    }
}
