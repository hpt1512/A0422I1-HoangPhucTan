package ss2_loop_in_java.thuc_hanh;

import java.util.Scanner;

public class CheckPrime {
    //   Kiểm tra số nguyên tố
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        number = scanner.nextInt();
        if (number < 2){
            System.out.println(number + " is not a prime");
        }
        else {
            int i = 2;
            boolean check = true;
            while (i < number) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check)
                System.out.println(number + " is a prime");
            else
                System.out.println(number + " is not a prime");
        }
    }
}
