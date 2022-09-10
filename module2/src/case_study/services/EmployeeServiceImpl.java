package case_study.services;

import case_study.models.Employee;
import case_study.utils.ReadAndWrite;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList = new ArrayList<>();
    private int count_id = 1;

    @Override
    public void display() {
        employeeList = (List<Employee>) ReadAndWrite.read("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\case_study\\data\\employee.csv");
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }
    @Override
    public void addnew() {
        int id = count_id++;
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter level: ");
            String level = scanner.nextLine();
            System.out.print("Enter position: ");
            String position = scanner.nextLine();
            System.out.print("Enter salary: ");
            int salary = Integer.parseInt(scanner.nextLine());

            Employee employee = new Employee(id, name, age, gender, email, level, position, salary);
            employeeList.add(employee);


            System.out.println(ANSI_CYAN + "-- Add successfully --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Input wrong format");
        }
        // Ghi file csv
        ReadAndWrite.write(employeeList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\case_study\\data\\employee.csv");
    }

    @Override
    public void edit() {
        System.out.print("Enter the employee id to edit: ");
        int id = scanner.nextInt();
        int count = 0;
        for (Employee employee : employeeList) {
            if (id == employee.getId()) {
                System.out.println(ANSI_CYAN + "Edit employee " + id + " :" + ANSI_RESET);
                System.out.print("Enter name: ");
                scanner.nextLine();
                String new_name = scanner.nextLine();
                System.out.print("Enter age: ");
                int new_age = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter gender: ");
                String new_gender = scanner.nextLine();
                System.out.print("Enter email: ");
                String new_email = scanner.nextLine();
                System.out.print("Enter level: ");
                String new_level = scanner.nextLine();
                System.out.print("Enter position: ");
                String new_position = scanner.nextLine();
                System.out.print("Enter salary: ");
                int new_salary = Integer.parseInt(scanner.nextLine());

                // Sửa thông tin
                employee.setName(new_name);
                employee.setAge(new_age);
                employee.setGender(new_gender);
                employee.setEmail(new_email);
                employee.setLevel(new_level);
                employee.setPosition(new_position);
                employee.setSalary(new_salary);

                System.out.println(ANSI_CYAN + "-- Edit successfully --" + ANSI_RESET);
                count++;
            }
        }
        if (count == 0) {
            System.err.println("NOT FOUND EMPLOYEE " + id);
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter the employee id to delete: ");
        int id = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            if (id == employeeList.get(i).getId()) {
                count++;
                employeeList.remove(i);
                System.out.println(ANSI_CYAN + "-- Delete successfully --" + ANSI_RESET);
            }
        }
        if (count == 0) {
            System.err.println("NOT FOUND EMPLOYEE " + id);
        }

        // Ghi file csv
        ReadAndWrite.write(employeeList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\case_study\\data\\employee.csv");

    }
}
