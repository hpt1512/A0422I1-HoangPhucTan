package a_thi_lai_module_2.controller;

import a_thi_lai_module_2.services.ProductServiceImpl;

import java.util.Scanner;

public class ShopController {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        ShopController.displayMainMenu();
    }

    public static void displayMainMenu() {
        ProductServiceImpl productService = new ProductServiceImpl();
        boolean check = true;
        int choose = 0;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_GREEN + "** CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM **" + ANSI_RESET);
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Xoá sản phẩm");
            System.out.println("3. Xem danh sách sản phẩm");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            Scanner scanner = new Scanner(System.in);
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("You entered wrong format");
            }

            if (choose < 1 || choose > 5) {
                System.err.println("INPUT ERROR - PLEASE ENTER A NUMBER VALUE IN [1-5]");
            }

            switch (choose) {
                case 1:
                    System.out.println(ANSI_CYAN + "THÊM MỚI SẢN PHẨM :" + ANSI_RESET);
                    displayAddProductMenu();
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "XOÁ SẢN PHẨM :" + ANSI_RESET);
                    productService.deleteProduct();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "DANH SÁCH SẢN PHẨM :" + ANSI_RESET);
                    productService.displayProduct();
                    break;
                case 4:
                    System.out.println(ANSI_CYAN + "TÌM KIẾM SẢN PHẨM :" + ANSI_RESET);
                    productService.searchProduct();
                    break;
                case 5:
                    System.out.println(ANSI_BLUE + "----- Exit program -----");
                    System.exit(0);
                    break;
            }
        }
    }
    // 1. Add product menu
    private static void displayAddProductMenu() {
        ProductServiceImpl productService = new ProductServiceImpl();
        boolean check = true;
        int choose = 0;
        while (check) {
            System.out.println("--------------------------");
            System.out.println("1. Thêm mới sản phẩm nhập khẩu");
            System.out.println("2. Thêm mới sản phẩm xuất khẩu");
            System.out.println("3. Quay lại");
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
                    System.out.println(ANSI_CYAN + "Thêm mới sản phẩm nhập khẩu :" + ANSI_RESET);
                    productService.addProductIn();
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "Thêm mới sản phẩm xuất khẩu :" + ANSI_RESET);
                    productService.addProductOut();
                    break;
                case 3:
                    displayMainMenu();
                    break;
            }
        }
    }



}
