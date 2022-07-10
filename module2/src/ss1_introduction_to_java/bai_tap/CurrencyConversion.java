package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền USD: ");
        usd = scanner.nextDouble();
        double result = usd * vnd;
        System.out.println("Giá trị VND: " + result);
    }
}
