package ss19_string_regex.practice;

import java.util.Scanner;

public class Main {
    public static int USCLN(int a, int b) {
        int temp1 = a;
        int temp2 = b;
        while (temp1 != temp2) {
            if (temp1 > temp2) {
                temp1 -= temp2;
            } else {
                temp2 -= temp1;
            }
        }
        int uscln = temp1;
        return uscln;
    }
    public static void main(String[] args) {
        //Scanner
        Scanner s = new Scanner(System.in);
//        int pink, green, red, orange, total;
//        int tp, tg, tr, tor, mini, count;
//
//        pink = s.nextInt();
//        green = s.nextInt();
//        red = s.nextInt();
//        orange = s.nextInt();
//        total = s.nextInt();
//
//        mini = 999999;
//        count = 0;
//        for (int a = 0; a <= total; a++) {
//            tp = a * pink;
//            for (int b = 0; b <= total; b++) {
//                tg = b * green;
//                for (int c = 0; c <= total; c++) {
//                    tr = c * red;
//                    for (int d = 0; d <= total; d++) {
//                        tor = d * orange;
//                        if (tp + tg + tr + tor == total) {
//                            if (a + b + c + d < mini) {
//                                mini = a + b + c + d;
//                            }
//                            count = count + 1;
//                            System.out.println("# of PINK is " + a + "  # of GREEN is " + b + "  # of RED is "+ c+ "  # of ORANGE is "+ d);
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println("Total combinations is " + count + ".");
//        System.out.println("Minimum number of tickets to print is " + mini + ".");


        int T = s.nextInt();
        int M = s.nextInt();

        int R = T / M;

        int D = T - R * M;

        if (D == 0) {
            System.out.println(R);
        } else {
            int ucln = USCLN(D, M);
            D = D / ucln;
            M = M / ucln;
            System.out.println(R + " " + D + "/" + M);
        }

    }
}