package case_study.controller;

import case_study.services.CustomerServiceImpl;
import case_study.services.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        FuramaController.displayMainMenu();
    }

    public static void displayMainMenu() {
        boolean check = true;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_GREEN + "** MAIN MENU **" + ANSI_RESET);
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.print("Enter your choose: ");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            if (choose < 1 || choose > 6) {
                System.err.println("INPUT ERROR - PLEASE ENTER A VALUE IN [1-6]");
            }

            switch (choose) {
                case 1:
                    displayEmployeeMenu();
                    break;
                case 2:
                    displayCustomerMenu();
                    break;
                case 3:
                    displayFacilityMenu();
                    break;
                case 4:
                    displayBookingMenu();
                    break;
                case 5:
                    displayPromotionMenu();
                    break;
                case 6:
                    System.out.println(ANSI_BLUE + "----- Exit program -----");
                    System.exit(0);
                    break;
            }
        }
    }

    //    1. MENU EMPLOYEE
    public static void displayEmployeeMenu() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_BLUE + "*** I. Employee Management" + ANSI_RESET);
            System.out.println("----- 1. Display list employees");
            System.out.println("----- 2. Add new employee");
            System.out.println("----- 3. Edit employee");
            System.out.println("----- 4. Delete employee");
            System.out.println("----- 5. Return main menu");
            System.out.print("Enter your choose: ");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            if (choose < 1 || choose > 5) {
                System.err.println("INPUT ERROR - PLEASE ENTER A VALUE IN [1-5]");
            }

            switch (choose) {
                case 1:
                    System.out.println(ANSI_CYAN + "EMPLOYEE LIST :" + ANSI_RESET);
                    employeeService.display();
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "ADD NEW EMPLOYEE :" + ANSI_RESET);
                    employeeService.addnew();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "EDIT A EMPLOYEE :" + ANSI_RESET);
                    employeeService.edit();
                    break;
                case 4:
                    System.out.println(ANSI_CYAN + "DELETE A EMPLOYEE :" + ANSI_RESET);
                    employeeService.delete();
                    break;
                case 5:
                    System.out.println(ANSI_CYAN + "RETURN MAIN MENU" + ANSI_RESET);
                    displayMainMenu(); // Return main menu
                    break;
            }
        }
    }

    //    2. MENU CUSTOMER
    public static void displayCustomerMenu() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_BLUE + "*** II. Customer Management" + ANSI_RESET);
            System.out.println("----- 1. Display list customers");
            System.out.println("----- 2. Add new customer");
            System.out.println("----- 3. Edit customer");
            System.out.println("----- 4. Delete a customer");
            System.out.println("----- 5. Return main menu");
            System.out.print("Enter your choose: ");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            if (choose < 1 || choose > 5) {
                System.err.println("INPUT ERROR - PLEASE ENTER A VALUE IN [1-5]");
            }

            switch (choose) {
                case 1:
                    System.out.println(ANSI_CYAN + "CUSTOMER LIST :" + ANSI_RESET);
                    customerService.display();
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "ADD NEW CUSTOMER :" + ANSI_RESET);
                    customerService.addnew();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "EDIT A CUSTOMER :" + ANSI_RESET);
                    customerService.edit();
                    break;
                case 4:
                    System.out.println(ANSI_CYAN + "DELETE A CUSTOMER :" + ANSI_RESET);
                    customerService.delete();
                    break;
                case 5:
                    System.out.println(ANSI_CYAN + "RETURN MAIN MENU" + ANSI_RESET);
                    displayMainMenu(); // Return main menu
                    break;
            }
        }
    }

    //    3. MENU FACILITY
    public static void displayFacilityMenu() {
        boolean check = true;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_BLUE + "*** III. Facility Management" + ANSI_RESET);
            System.out.println("----- 1. Display list facility");
            System.out.println("----- 2. Add new facility");
            System.out.println("----- 3. Display list facility maintenance");
            System.out.println("----- 4. Return main menu");
            System.out.print("Enter your choose: ");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            if (choose < 1 || choose > 4) {
                System.err.println("INPUT ERROR - PLEASE ENTER A VALUE IN [1-4]");
            }

            switch (choose) {
                case 1:
                    break;
                case 2: {
                    boolean check_add = true;
                    while (check_add) {
                        System.out.println(ANSI_CYAN + "ADD NEW FACILITY :" + ANSI_RESET);
                        System.out.println("----- 1. Add New Villa");
                        System.out.println("----- 2. Add New House");
                        System.out.println("----- 3. Add New Room");
                        System.out.println("----- 4. Return Facility Menu");
                        System.out.print("Enter your choose: ");

                        int choose_add = scanner.nextInt();

                        if (choose_add < 1 || choose_add > 4) {
                            System.err.println("INPUT ERROR - PLEASE ENTER A VALUE IN [1-4]");
                        }

                        switch (choose_add) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                System.out.println(ANSI_CYAN + "RETURN MAIN MENU" + ANSI_RESET);
                                displayFacilityMenu(); // Return facility menu
                                break;
                        }
                    }
                    break;
                }
                case 3:
                    break;
                case 4:
                    System.out.println(ANSI_CYAN + "RETURN MAIN MENU" + ANSI_RESET);
                    displayMainMenu(); // Return main menu
                    break;
            }
        }
    }

    //    4. MENU BOOKING
    public static void displayBookingMenu() {
        boolean check = true;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_BLUE + "*** IV. Booking Management" + ANSI_RESET);
            System.out.println("----- 1. Add new booking");
            System.out.println("----- 2. Display list booking");
            System.out.println("----- 3. Create new constracts");
            System.out.println("----- 4. Display list contracts");
            System.out.println("----- 5. Edit contracts");
            System.out.println("----- 6. Return main menu");
            System.out.print("Enter your choose: ");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            if (choose < 1 || choose > 6) {
                System.err.println("INPUT ERROR - PLEASE ENTER A VALUE IN [1-6]");
            }

            switch (choose) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println(ANSI_CYAN + "RETURN MAIN MENU" + ANSI_RESET);
                    displayMainMenu(); // Return main menu
                    break;
            }
        }
    }

    //    5. MENU PROMOTION
    public static void displayPromotionMenu() {
        boolean check = true;
        while (check) {
            System.out.println("--------------------------");
            System.out.println(ANSI_BLUE + "*** V. Promotion Management" + ANSI_RESET);
            System.out.println("----- 1. Display list customers use service");
            System.out.println("----- 2. Display list customers get voucher");
            System.out.println("----- 3. Return main menu");
            System.out.print("Enter your choose: ");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            if (choose < 1 || choose > 3) {
                System.err.println("INPUT ERROR - PLEASE ENTER A VALUE IN [1-3]");
            }

            switch (choose) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "RETURN MAIN MENU" + ANSI_RESET);
                    displayMainMenu(); // Return main menu
                    break;
            }
        }
    }

}
