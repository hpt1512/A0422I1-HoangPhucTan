package ss11_stack_queue.exercise.demerging;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Object> maleQueue = new ArrayDeque<>(); //nam
        Queue<Object> femaleQueue = new ArrayDeque<>(); //nu

        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập số lượng nhân viên: ");
//        int countEmplyee = Integer.parseInt(scanner.nextLine());

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Nhân viên nam 1", "nam", LocalDate.parse("2000-12-15")));
        employees.add(new Employee("Nhân viên nữ 1", "nu", LocalDate.parse("2000-10-15")));
        employees.add(new Employee("Nhân viên nam 2", "nam", LocalDate.parse("2000-11-15")));
        employees.add(new Employee("Nhân viên nữ 2", "nu", LocalDate.parse("2000-08-15")));
        employees.add(new Employee("Nhân viên nữ 3", "nu", LocalDate.parse("2000-09-15")));

//        for (int i = 0; i < countEmplyee; i++) {
//            System.out.println("Nhập nhân viên thứ " + (i + 1) + " : ");
//            System.out.print("Nhập tên: ");
//            String name = scanner.nextLine();
//            System.out.print("Nhập giới tính: ");
//            String gender = scanner.nextLine();
//            System.out.print("Nhập ngày sinh: ");
//            String birthday = scanner.nextLine();
//
//            employees.add(new Employee(name, gender, LocalDate.parse(birthday)));
//        }

        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        for (Employee item : employees) {
            if (item.getGender() == "nam") {
                maleQueue.add(item);
            } else {
                femaleQueue.add(item);
            }
        }

        System.out.println("-----------------------------------");

        for (int i = 0; i < employees.size(); i++) {
            System.out.println("Thông tin nhân viên thứ " + (i + 1) + " : ");
            System.out.println("Name : " + employees.get(i).getName());
            System.out.println("Gender : " + employees.get(i).getGender());
            System.out.println("Birtday : " + employees.get(i).getBirthday());
        }

        ArrayList<Employee> outputs = new ArrayList<>();

        while (!femaleQueue.isEmpty()) {
            outputs.add((Employee) femaleQueue.poll());
        }
        while (!maleQueue.isEmpty()) {
            outputs.add((Employee) maleQueue.poll());
        }

        System.out.println("-----------------------------------");
        System.out.println("-----------SAU KHI SẮP XẾP---------");
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println("Thông tin nhân viên thứ " + (i + 1) + " : ");
            System.out.println("Name : " + outputs.get(i).getName());
            System.out.println("Gender : " + outputs.get(i).getGender());
            System.out.println("Birtday : " + outputs.get(i).getBirthday());
        }

    }
}
