package case_study.services;

import case_study.models.Booking;
import case_study.models.Contract;
import case_study.models.Customer;
import case_study.models.Facility;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    static List<Contract> contractList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private int count_idContract = 1;

    @Override
    public void createNewContract() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomer();

            System.out.println("Creating new contract for : " + booking.toString());
            System.out.println("Creating new contract for : " + customer.toString());

            String idContract = "CT" + count_idContract++;
            System.out.println("Enter prepayment amount: ");
            int pre = scanner.nextInt();
            System.out.println("Enter payment amount: ");
            int pay = scanner.nextInt();

            Contract contract = new Contract(idContract, booking, pre, pay, customer);
            contractList.add(contract);

            System.out.println(ANSI_CYAN + "-- Create successfully --" + ANSI_RESET);
        }
    }

    public List<Contract> sendContract() {
        return contractList;
    }
    @Override
    public void displaylistContract() {
        for (Contract contract : contractList) {
            System.out.println(contract.toString());
        }
    }

}
