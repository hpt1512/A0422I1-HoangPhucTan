package ss2_loop_in_java.exercise;

import java.util.Scanner;

public class DisplayPrime {
    //    Hiển thị 20 số nguyên tố đầu tiên
    public static void main(String[] args) {
        int number;
        int count = 0; //đếm số lượng snt
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần in ra: ");
        number = Integer.parseInt(scanner.nextLine());

        int N = 2;
        while (count < number) {
            int dem = 0;
            for (int i = 1; i <= N; i++) {
                if (N % i == 0) {
                    dem++;
                }
            }
            if (dem == 2) {
                System.out.print(N + "\t");
                count++;
            }
            N++;
        }
    }
}
