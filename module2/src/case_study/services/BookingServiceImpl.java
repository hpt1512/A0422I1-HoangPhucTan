package case_study.services;

import case_study.models.*;
import case_study.utils.BookingComparetor;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparetor());
    static List<Customer> customerList = new CustomerServiceImpl().sendCustomer();
    static Map<Facility, Integer> facilityIntegerMap = new FacilityServiceImpl().sendFacility();
    private static Scanner scanner = new Scanner(System.in);
    private int count_idBooking = 1;

//    static {
//        customerList.add(new Customer(1, "Khách hàng 1", 21, "Nam", "khachhang1@gmail.com", "Casual", "Quảng Nam"));
//        customerList.add(new Customer(2, "Khách hàng 2", 22, "Nam", "khachhang2@gmail.com", "VIP", "Đà Nẵng"));
//        customerList.add(new Customer(3, "Khách hàng 3", 23, "Nữ", "khachhang3@gmail.com", "Casual", "Huế"));
//
//        facilityIntegerMap.put(new Villa("VL1", "Villa 1", 200, 5000000, 10, "Day", "3 sao", 20, 3), 0);
//        facilityIntegerMap.put(new House("H1", "Villa 1", 200, 5000000, 10, "Day", "3 sao", 3), 0);
//        facilityIntegerMap.put(new Room("R1", "Villa 1", 200, 5000000, 10, "Day", "3 sao"), 0);
//    }

    @Override
    public void addBooking() {
        int id = count_idBooking++;
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        System.out.print("Enter start date: ");
        String startDate = scanner.nextLine();
        System.out.print("Enter end date: ");
        String endDate = scanner.nextLine();

        Booking booking = new Booking(id, startDate, endDate, customer, facility);
        bookingSet.add(booking);

        System.out.println(ANSI_CYAN + "-- Add successfully --" + ANSI_RESET);
    }

    @Override
    public void displayListBooking() {
        for (Booking booking : bookingSet) {
            System.out.println(booking.toString());
        }
    }

    public Set<Booking> sendBooking() {
        return bookingSet;
    }

    public static Customer chooseCustomer() {
        System.out.println(ANSI_CYAN + "CUSTOMER LIST :" + ANSI_RESET);
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }

        System.out.print("Enter customer id: ");
        boolean check = true;
        while (check) {
            int id = Integer.parseInt(scanner.nextLine());
            for (Customer customer : customerList) {
                if (id == customer.getId()) {
                    check = false;
                    return customer;
                }
            }
            if (check) {
                System.out.print("Input error - Please enter again customer id: ");
            }
        }
        return null;
    }
    public static Facility chooseFacility() {
        System.out.println(ANSI_CYAN + "FACILITY LIST :" + ANSI_RESET);
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println(element.getKey().toString());
        }
        System.out.print("Enter facility id: ");
        boolean check = true;
        while (check) {
            String idFacility = scanner.nextLine();
            for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
                if (idFacility.equals(element.getKey().getIdFacility())) {
                    check = false;
                    return element.getKey();
                }
            }
            if (check) {
                System.out.print("Input error - Please enter again facility id: ");
            }
        }
        return null;
    }
}
