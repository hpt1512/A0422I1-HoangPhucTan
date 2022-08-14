package ss11_stack_queue.exercise.demerging;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Object> male = new ArrayDeque<>();
        Queue<Object> female = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng nhân viên: ");
        int countEmplyee = Integer.parseInt(scanner.nextLine());

        ArrayList<Employee> employees = new ArrayList<>(countEmplyee);

        employees.add(new Employee("phuc tan", "nam",  LocalDate.parse("2000-12-15")));

        for (int i = 0; i < countEmplyee; i++) {
            System.out.println("Nhập nhân viên thứ " + (i + 1) + " : ");
            System.out.println("Nhập tên: ");
            String name = scanner.nextLine();
            System.out.println("Nhập giới tính: ");
            String gender = scanner.nextLine();
            System.out.println("Nhập ngày sinh: ");
            String birthday = scanner.nextLine();

            employees.add(new Employee(name, gender, LocalDate.parse(birthday)));
        }

        employees.stream().forEach(System.out::println);

    }
}
