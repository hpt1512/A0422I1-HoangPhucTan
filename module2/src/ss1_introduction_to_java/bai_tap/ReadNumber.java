package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        int number;
        String result = "";
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.print("Enter a number for read: ");
            number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Input error - Enter again");
            }
        } while (number < 0);

        if (number >= 0 && number < 10) {
            switch (number) {
                case 0:
                    result += "zero";
                    break;
                case 1:
                    result += "one";
                    break;
                case 2:
                    result += "two";
                    break;
                case 3:
                    result += "three";
                    break;
                case 4:
                    result += "four";
                    break;
                case 5:
                    result += "five";
                    break;
                case 6:
                    result += "six";
                    break;
                case 7:
                    result += "seven";
                    break;
                case 8:
                    result += "eight";
                    break;
                case 9:
                    result += "nine";
                    break;
            }
        } else if (number < 20) {
            int unitNumber;
            unitNumber = number % 10;
            switch (unitNumber) {
                case 3:
                    result += "three";
                    break;
                case 4:
                    result += "four";
                    break;
                case 5:
                    result += "five";
                    break;
                case 6:
                    result += "six";
                    break;
                case 7:
                    result += "seven";
                    break;
                case 8:
                    result += "eight";
                    break;
                case 9:
                    result += "nine";
                    break;
            }
            if (unitNumber == 1) {
                result += "eleven";
            } else if (unitNumber == 2) {
                result += "twelve";
            } else if (unitNumber == 0) {
                result += "ten";
            } else {
                result += "teen";
            }
//            System.out.println(unitNumber);
        } else if (number < 1000) {
            if (number / 100 > 1) {

            } else {

            }
        }
        System.out.println(result);
    }
}
