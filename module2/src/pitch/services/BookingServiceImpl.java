package pitch.services;

import case_study.utils.ReadAndWrite;
import pitch.models.BookingPitch;
import pitch.models.Customer;
import pitch.models.Pitch;
import pitch.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingServiceImpl implements BookingService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private List<BookingPitch> bookingPitchList = new ArrayList<>();
    private static List<Customer> customerList = new CustomerServiceImpl().sendCustomer();
    private static List<Pitch> pitchList = new PitchServiceImpl().sendPitch();
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void addBooking() {
        try {
            System.out.println("Nhập id booking");
            String idBooking = scanner.nextLine();
            Customer customer = chooseCustomer();
            Pitch pitch = choosePitch();
            System.out.println("Nhập thời gian bắt đầu: ");
            String timeStart = inputTime();
            System.out.println("Nhập thời gian kết thúc: ");
            String timeEnd = inputTime();

            BookingPitch bookingPitch = new BookingPitch(idBooking, customer, pitch, timeStart, timeEnd);
            bookingPitchList.add(bookingPitch);

            System.out.println(ANSI_CYAN + "-- Thêm mới thành công --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Nhập sai định dạng");
        }
        // Ghi file csv
        ReadAndWrite.write(bookingPitchList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\pitch\\data\\booking_pitch.csv");

    }
    public static Customer chooseCustomer() {
        customerList = (List<Customer>) pitch.utils.ReadAndWrite.read("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\pitch\\data\\customer.csv");
        System.out.println(ANSI_CYAN + "CUSTOMER LIST :" + ANSI_RESET);
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }

        System.out.println("Nhập id khách hàng: ");
        boolean check = true;
        while (check) {
            String id = scanner.nextLine();
            for (Customer customer : customerList) {
                if (id.equals(customer.getIdCustomer())) {
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
    public static Pitch choosePitch() {
        System.out.println(ANSI_CYAN + "PITCH LIST :" + ANSI_RESET);
        pitchList = (List<Pitch>) pitch.utils.ReadAndWrite.read("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\pitch\\data\\pitch.csv");
        for (Pitch pitch : pitchList) {
            System.out.println(pitch.toString());
        }

        System.out.println("Nhập id sân bóng: ");
        boolean check = true;
        while (check) {
            String id = scanner.nextLine();
            for (Pitch pitch : pitchList) {
                if (id.equals(pitch.getIdPitch())) {
                    check = false;
                    return pitch;
                }
            }
            if (check) {
                System.out.print("Input error - Please enter again pitch id: ");
            }
        }
        return null;
    }

    @Override
    public void displayListBooking() {
        bookingPitchList = (List<BookingPitch>) pitch.utils.ReadAndWrite.read("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\pitch\\data\\booking_pitch.csv");
        for (BookingPitch bookingPitch : bookingPitchList) {
            System.out.println(bookingPitch.toString());
        }
    }

    @Override
    public void deleteBooking() {
        System.out.print("Nhập id booking muốn xoá: ");
        String id = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < bookingPitchList.size(); i++) {
            if (id.equals(bookingPitchList.get(i).getIdBooking())) {
                count++;
                bookingPitchList.remove(i);
                System.out.println(ANSI_CYAN + "-- Xoá thành công --" + ANSI_RESET);
            }
        }
        if (count == 0) {
            System.err.println("KHÔNG TÌM THẤY " + id);
        }
        // Ghi file csv
        ReadAndWrite.write(bookingPitchList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\pitch\\data\\booking_pitch.csv");

    }

    @Override
    public void updateBooking() {

    }

    // Validate input value
    public String inputTime() {
        String time = scanner.nextLine();
        return RegexData.regexStr(time,"^[0-2][0-9]:00$", "Nhập sai định dạng, id khách hàng phải có định dạng là XX:XX");
    }
}
