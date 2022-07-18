package ss4_class_and_object_in_java.bai_tap.stop_watch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        Scanner scanner = new Scanner(System.in);

        watch.start();

        System.out.print("-----Xác nhận bắt đầu (Nhấm phím Enter)-----");
        scanner.nextLine();
        watch.start();
        System.out.println("Tính thời gian bắt đầu lúc " + watch.getStartTime());

        System.out.println();

        System.out.print("-----Xác nhận kết thúc (Nhấm phím Enter)-----");
        scanner.nextLine();
        watch.stop();
        System.out.println("Tính thời gian kết thúc lúc " + watch.getEndTime());

        System.out.println("Khoảng thời gian đã trôi qua: " + watch.getElapsedTime() + " milisecond");

    }
}
