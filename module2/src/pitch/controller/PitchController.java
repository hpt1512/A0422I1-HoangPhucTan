package pitch.controller;

import pitch.services.BookingServiceImpl;
import pitch.services.CustomerServiceImpl;
import pitch.services.PitchServiceImpl;

import java.util.Scanner;

public class PitchController {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        PitchController.displayMainMenu();
    }

    public static void displayMainMenu() {
        boolean check = true;
        int choose = 0;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_GREEN + "** CHƯƠNG TRÌNH QUẢN LÝ SÂN BÓNG **" + ANSI_RESET);
            System.out.println("1. Quản lý sân bóng");
            System.out.println("2. Quản lý khách hàng");
            System.out.println("3. Quản lý đặt sân bóng");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");

            Scanner scanner = new Scanner(System.in);
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("You entered wrong format");
            }

            if (choose < 1 || choose > 4) {
                System.err.println("INPUT ERROR - PLEASE ENTER A NUMBER VALUE IN [1-4]");
            }

            switch (choose) {
                case 1:
                    displayMenuPitch();
                    break;
                case 2:
                    displayMenuCustomer();
                    break;
                case 3:
                    displayMenuBookingPitch();
                    break;
                case 4:
                    System.out.println(ANSI_BLUE + "----- Exit program -----");
                    System.exit(0);
                    break;
            }
        }
    }


    private static void displayMenuCustomer() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        boolean check = true;
        int choose = 0;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_GREEN + "QUẢN LÝ KHÁCH HÀNG" + ANSI_RESET);
            System.out.println("1. Thêm mới khách hàng");
            System.out.println("2. Hiển thị danh sách khách hàng");
            System.out.println("3. Xoá khách hàng");
            System.out.println("4. Quay lại");
            System.out.print("Chọn chức năng: ");

            Scanner scanner = new Scanner(System.in);
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("You entered wrong format");
            }

            if (choose < 1 || choose > 4) {
                System.err.println("INPUT ERROR - PLEASE ENTER A NUMBER VALUE IN [1-4]");
            }

            switch (choose) {
                case 1:
                    System.out.println(ANSI_CYAN + "THÊM MỚI KHÁCH HÀNG :" + ANSI_RESET);
                    customerService.addCustomer();
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "DANH SÁCH KHÁCH HÀNG :" + ANSI_RESET);
                    customerService.displayListCustomer();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "XOÁ KHÁCH HÀNG :" + ANSI_RESET);
                    customerService.deleteCustomer();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }
    private static void displayMenuPitch() {
        PitchServiceImpl pitchService = new PitchServiceImpl();
        boolean check = true;
        int choose = 0;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_GREEN + "QUẢN LÝ SÂN BÓNG" + ANSI_RESET);
            System.out.println("1. Thêm mới sân bóng");
            System.out.println("2. Hiển thị danh sách sân bóng");
            System.out.println("3. Xoá sân bóng");
            System.out.println("4. Quay lại");
            System.out.print("Chọn chức năng: ");

            Scanner scanner = new Scanner(System.in);
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("You entered wrong format");
            }

            if (choose < 1 || choose > 4) {
                System.err.println("INPUT ERROR - PLEASE ENTER A NUMBER VALUE IN [1-4]");
            }

            switch (choose) {
                case 1:
                    System.out.println(ANSI_CYAN + "THÊM MỚI SÂN BÓNG :" + ANSI_RESET);
                    pitchService.addPitch();
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "DANH SÁCH SÂN BÓNG :" + ANSI_RESET);
                    pitchService.displayPitch();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "XOÁ SÂN BÓNG :" + ANSI_RESET);
                    pitchService.deletePitch();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }
    private static void displayMenuBookingPitch() {
        BookingServiceImpl bookingService = new BookingServiceImpl();
        boolean check = true;
        int choose = 0;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_GREEN + "QUẢN LÝ ĐẶT SÂN BÓNG" + ANSI_RESET);
            System.out.println("1. Đặt sân bóng mới");
            System.out.println("2. Hiển thị danh sách đặt sân");
            System.out.println("3. Xoá đặt sân");
            System.out.println("4. Quay lại");
            System.out.print("Chọn chức năng: ");

            Scanner scanner = new Scanner(System.in);
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("You entered wrong format");
            }

            if (choose < 1 || choose > 4) {
                System.err.println("INPUT ERROR - PLEASE ENTER A NUMBER VALUE IN [1-4]");
            }

            switch (choose) {
                case 1:
                    System.out.println(ANSI_CYAN + "ĐẶT SÂN BÓNG MỚI :" + ANSI_RESET);
                    bookingService.addBooking();
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "DANH SÁCH ĐẶT SÂN :" + ANSI_RESET);
                    bookingService.displayListBooking();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "XOÁ ĐẶT SÂN :" + ANSI_RESET);
                    bookingService.deleteBooking();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }
}
