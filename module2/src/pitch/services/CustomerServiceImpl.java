package pitch.services;

import case_study.utils.ReadAndWrite;
import pitch.models.Customer;
import pitch.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private List<Customer> customerList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void addCustomer() {
        try {
            System.out.println("Nhập id khách hàng");
            String id = inputId();
            System.out.println("Nhập tên khách hàng: ");
            String name = scanner.nextLine();
            System.out.println("Nhập tuổi: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập địa chỉ: ");
            String address = scanner.nextLine();

            Customer customer = new Customer(id, name, age, address);
            customerList.add(customer);

            System.out.println(ANSI_CYAN + "-- Thêm mới thành công --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Nhập sai định dạng");
        }
        // Ghi file csv
        ReadAndWrite.write(customerList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\pitch\\data\\customer.csv");

    }

    @Override
    public void displayListCustomer() {
        customerList = (List<Customer>) pitch.utils.ReadAndWrite.read("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\pitch\\data\\customer.csv");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void deleteCustomer() {
        System.out.print("Nhập id khách hàng muốn xoá: ");
        String id = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < customerList.size(); i++) {
            if (id.equals(customerList.get(i).getIdCustomer())) {
                count++;
                customerList.remove(i);
                System.out.println(ANSI_CYAN + "-- Xoá thành công --" + ANSI_RESET);
            }
        }
        if (count == 0) {
            System.err.println("KHÔNG TÌM THẤY " + id);
        }
        // Ghi file csv
        ReadAndWrite.write(customerList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\pitch\\data\\customer.csv");

    }

    @Override
    public void updateCustomer() {

    }
    public List<Customer> sendCustomer() {
        return customerList;
    }

    // Validate input value
    private String inputId() {
        String id = scanner.nextLine();
        return RegexData.regexStr(id,"^KH-[0-9][0-9]$", "Nhập sai định dạng, id khách hàng phải có định dạng là KH-XX");
    }

}
