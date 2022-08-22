package exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DemoException {
    public static void main(String[] args) {
//        System.out.println("Nhap so a: ");
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        System.out.println("Nhap so b: ");
//        int b = scanner.nextInt();
//        System.out.println("a/b = " + a/b);
//        System.out.println("Success");
//        testException();

//        try {
//            testException2();
//        } catch (ParseException e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            testExceptionDefine();
//        } catch (DateException e) {
//            System.out.println(e.getMessage());
//        }


        // check validate
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("nhap vao n: ");
//        int n = scanner.nextInt();
//        while (true) {
//            try {
//                if (checkNumber(n)) {
//                    break;
//                }
//            } catch (NumberException e) {
//                System.out.println(e.getMessage());
//                System.out.println("nhap lai n: ");
//                n = scanner.nextInt();
//            }
//        }

        // try finally
        try {
            testException3();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void testException() {
        Date date;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao ngay (dd/MM/yyyy):");
        String dateAsString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = format.parse(dateAsString);
            System.out.println("None error");
            System.out.println(date.toString());
//            int a = 4 / 0;
            "aaa".charAt(10);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("finally");
        }
        System.out.println("success");
    }

    public static void testException2() throws ParseException {
        Date date;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao ngay (dd/MM/yyyy):");
        String dateAsString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        date = format.parse(dateAsString);
        System.out.println("None error");
        System.out.println(date.toString());
    }

    public static void testExceptionDefine() throws DateException {
        Date date;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao ngay (dd/MM/yyyy):");
        String dateAsString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = format.parse(dateAsString);
        } catch (ParseException e) {
            throw new DateException("Ngay khong hop le");
        }
        System.out.println("None error");
        System.out.println(date.toString());
    }

    public static boolean checkNumber(int n) throws NumberException {
        if (n < 0) {
            throw new NumberException("N khong the be hon 0");
        }

        if (n > 50) {
            throw new NumberException("N khong the lon hon 50");
        }

        return true;
    }

    public static void testException3() throws ParseException {
        Date date;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao ngay (dd/MM/yyyy):");
        String dateAsString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = format.parse(dateAsString);
            System.out.println("None error");
            System.out.println(date.toString());
        } finally {
            System.out.println("success");
        }
    }
}
