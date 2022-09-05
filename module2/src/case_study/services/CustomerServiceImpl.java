package case_study.services;

import case_study.models.Customer;
import case_study.models.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customerList = new LinkedList<>();

    @Override
    public void display() {
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addnew() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter typeCustomer: ");
        String typeCustomer = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(id, name, age, gender, email, typeCustomer, address);
        customerList.add(customer);

        System.out.println(ANSI_CYAN + "-- Add successfully --" + ANSI_RESET);
    }

    @Override
    public void edit() {
        System.out.print("Enter the customer id to edit: ");
        int id = scanner.nextInt();
        int count = 0;
        for (Customer customer : customerList) {
            if (id == customer.getId()) {
                System.out.println(ANSI_CYAN + "Edit customer " + id + " :" + ANSI_RESET);
                System.out.print("Enter id: ");
                scanner.nextLine();
                int new_id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter name: ");
                String new_name = scanner.nextLine();
                System.out.print("Enter age: ");
                int new_age = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter gender: ");
                String new_gender = scanner.nextLine();
                System.out.print("Enter email: ");
                String new_email = scanner.nextLine();
                System.out.print("Enter typeCustomer: ");
                String new_typeCustomer = scanner.nextLine();
                System.out.print("Enter address: ");
                String new_address = scanner.nextLine();

                // Sửa thông tin
                customer.setId(new_id);
                customer.setName(new_name);
                customer.setAge(new_age);
                customer.setGender(new_gender);
                customer.setEmail(new_email);
                customer.setTypeCustomer(new_typeCustomer);
                customer.setAddress(new_address);

                System.out.println(ANSI_CYAN + "-- Edit successfully --" + ANSI_RESET);
                count++;
            }
        }
        if (count == 0) {
            System.err.println("NOT FOUND CUSTOMER " + id);
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter the customer id to delete: ");
        int id = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < customerList.size(); i++) {
            if (id == customerList.get(i).getId()) {
                count++;
                customerList.remove(i);
                System.out.println(ANSI_CYAN + "-- Delete successfully --" + ANSI_RESET);
            }
        }
        if (count == 0) {
            System.err.println("NOT FOUND CUSTOMER " + id);
        }
    }
}
