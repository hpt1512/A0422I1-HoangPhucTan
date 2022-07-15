package ss3_array_and_method_in_java.bai_tap;

public class CountSumMainDiagonal {
    //    Mảng hai chiều - tính tổng các số ở đường chéo chính của ma trận vuông
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        int sum = 0;

        System.out.println("Các số trong đường chéo chính: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == i) {
                    sum = sum + arr[i][i];
                    System.out.print(arr[i][i] + "\t");
                }
            }
        }
        System.out.println();
        System.out.println("Tổng các số trong đường chéo chính là: " + sum);
    }
}
