package case_study.controller;

import java.util.Scanner;

public class FuramaController {
    public static void displayMainMenu() {


        Scanner scanner = new Scanner(System.in);

        int choose_1;
//        do {
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.print("Enter your choose: ");
            choose_1 = scanner.nextInt();

            int choose_2;
            switch (choose_1) {
                case 1:
                    System.out.println("*** Employee Management");
                    System.out.println("----- 1. Display list employees");
                    System.out.println("----- 2. Add new employee");
                    System.out.println("----- 3. Edit employee");
                    System.out.println("----- 4. Return main menu");
                    System.out.print("Enter your choose: ");
                    choose_2 = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("*** Customer Management");
                    System.out.println("----- 1. Display list customers");
                    System.out.println("----- 2. Add new customer");
                    System.out.println("----- 3. Edit customer");
                    System.out.println("----- 4. Return main menu");
                    System.out.print("Enter your choose: ");
                    choose_2 = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("*** Facility Management");
                    System.out.println("----- 1. Display list facility");
                    System.out.println("----- 2. Add new facility");
                    System.out.println("----- 3. Display list facility maintenance");
                    System.out.println("----- 4. Return main menu");
                    System.out.print("Enter your choose: ");
                    choose_2 = scanner.nextInt();
                case 4:
                    System.out.println("*** Booking Management");
                    System.out.println("----- 1. Add new booking");
                    System.out.println("----- 2. Display list booking");
                    System.out.println("----- 3. Create new constracts");
                    System.out.println("----- 4. Display list contracts");
                    System.out.println("----- 5. Edit contracts");
                    System.out.println("----- 5. Return main menu");
                    System.out.print("Enter your choose: ");
                    choose_2 = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("*** Promotion Management");
                    System.out.println("----- 1. Display list customers use service");
                    System.out.println("----- 2. Display list customers get voucher");
                    System.out.println("----- 3. Return main menu");
                    System.out.print("Enter your choose: ");
                    choose_2 = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("----- Exit program -----");
                    System.exit(0);
                    break;
            }


            if (choose_1 < 0 || choose_1 > 6) {
                System.out.println("Input erorr");
            }

//        } while (choose_1 != 0);



    }
}
