package a_thi_module2.controller;

import a_thi_module2.services.TermServiceImpl;

import java.util.Scanner;

public class BankController {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        BankController.displayMainMenu();
    }

    public static void displayMainMenu() {
        TermServiceImpl termService = new TermServiceImpl();
        boolean check = true;
        int choose = 0;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_GREEN + "** CHƯƠNG TRÌNH QUẢN LÝ SỔ TIẾT KIỆM **" + ANSI_RESET);
            System.out.println("1. Thêm mới sổ tiết kiệm");
            System.out.println("2. Xoá sổ tiết kiệm");
            System.out.println("3. Xem danh sách sổ tiết kiệm");
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
                    System.out.println(ANSI_CYAN + "THÊM MỚI SỔ TIẾT KIỆM :" + ANSI_RESET);
                    displayMenuAddNewTerm();
                    break;
                case 2:
                    displayMenuDeleteNewTerm();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "DANH SÁCH SỔ TIẾT KIỆM :" + ANSI_RESET);
                    termService.display();
                    break;
                case 4:
                    System.out.println(ANSI_BLUE + "----- Exit program -----");
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenuDeleteNewTerm() {
        TermServiceImpl termService = new TermServiceImpl();
        boolean check = true;
        int choose = 0;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_BLUE + "*** I. Xoá sổ tiết kiệm" + ANSI_RESET);
            System.out.println("----- 1. Xoá sổ ngắn hạn");
            System.out.println("----- 2. Xoá sổ dài hạn");
            System.out.println("----- 3. Quay lại");
            System.out.print("Chọn chức năng: ");

            Scanner scanner = new Scanner(System.in);
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("You entered wrong format");
            }

            if (choose < 1 || choose > 3) {
                System.err.println("INPUT ERROR - PLEASE ENTER A NUMBER VALUE IN [1-3]");
            }

            switch (choose) {
                case 1:
                    termService.deleteShortTerm();
                    break;
                case 2:
                    termService.deleteLongTerm();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "RETURN MAIN MENU" + ANSI_RESET);
                    displayMainMenu(); // Return main menu
                    break;
            }
        }
    }
    // 1. Them moi so tiet kiem

    public static void displayMenuAddNewTerm() {
        TermServiceImpl termService = new TermServiceImpl();
        boolean check = true;
        int choose = 0;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_BLUE + "*** I. Thêm mới sổ tiết kiệm" + ANSI_RESET);
            System.out.println("----- 1. Thêm sổ ngắn hạn");
            System.out.println("----- 2. Thêm sổ dài hạn");
            System.out.println("----- 3. Quay lại");
            System.out.print("Chọn chức năng: ");

            Scanner scanner = new Scanner(System.in);
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("You entered wrong format");
            }

            if (choose < 1 || choose > 3) {
                System.err.println("INPUT ERROR - PLEASE ENTER A NUMBER VALUE IN [1-3]");
            }

            switch (choose) {
                case 1:
                    displayShortTernMenu();
                    break;
                case 2:
                    termService.addNewLongTerm();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "RETURN MAIN MENU" + ANSI_RESET);
                    displayMainMenu(); // Return main menu
                    break;
            }
        }
    }

    private static void displayShortTernMenu() {
        TermServiceImpl termService = new TermServiceImpl();
        boolean check = true;
        int choose = 0;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_BLUE + "*** Thêm mới sổ tiết kiệm ngắn hạn" + ANSI_RESET);
            System.out.println("----- 1. Thêm sổ ngắn hạn vô thời hạn");
            System.out.println("----- 2. Thêm sổ ngắn hạn có thời hạn");
            System.out.println("----- 3. Quay lại");
            System.out.print("Chọn chức năng: ");

            Scanner scanner = new Scanner(System.in);
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("You entered wrong format");
            }

            if (choose < 1 || choose > 3) {
                System.err.println("INPUT ERROR - PLEASE ENTER A NUMBER VALUE IN [1-3]");
            }

            switch (choose) {
                case 1:
                    termService.addNewShortTermNoTime();
                    break;
                case 2:
                    termService.addNewShortTermHasTime();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "RETURN" + ANSI_RESET);
                    displayMenuAddNewTerm(); // Return main menu
                    break;
            }
        }
    }
}
