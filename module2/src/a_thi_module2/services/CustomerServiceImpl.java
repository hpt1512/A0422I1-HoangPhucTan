package a_thi_module2.services;

import a_thi_module2.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private static Scanner scanner = new Scanner(System.in);
    private static List<a_thi_module2.models.Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Phuc Tan"));
        customerList.add(new Customer(2, "Phuc Tai"));
    }
    public List<a_thi_module2.models.Customer> sendCustomer() {
        return customerList;
    }
}
