package a_thi_module2.services;

import a_thi_module2.models.LongTerm;
import a_thi_module2.models.ShortTermHasTime;
import a_thi_module2.models.ShortTermNoTime;
import a_thi_module2.models.Term;
import case_study.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TermServiceImpl implements TermService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private static List<Term> termLongArrayList = new ArrayList<>();
    private static List<Term> termShortArrayList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        termLongArrayList = (List<Term>) ReadAndWrite.read("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\a_thi_module2\\data\\LongTerm.csv");
        for (Term term : termLongArrayList) {
            System.out.println(term.toString());
        }
        termShortArrayList = (List<Term>) ReadAndWrite.read("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\a_thi_module2\\data\\ShortTerm.csv");
        for (Term term : termShortArrayList) {
            System.out.println(term.toString());
        }
    }

    @Override
    public void addNewShortTermNoTime() {
        try {
            System.out.print("Nhập mã sổ: ");
            int idTerm = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập khách hàng: ");
            int idCustomer = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập ngày mở sổ: ");
            String dayOpenTerm = scanner.nextLine();
            System.out.print("Nhập thời gian bắt đầu gửi: ");
            String timeStartSend = scanner.nextLine();
            System.out.print("Nhập số tiền: ");
            int money = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập lãi suất: ");
            double laiSuat = Double.parseDouble(scanner.nextLine());

            ShortTermNoTime shortTermNoTime = new ShortTermNoTime(idTerm, idCustomer, dayOpenTerm, timeStartSend, money, laiSuat);
            termShortArrayList.add(shortTermNoTime);

            System.out.println(ANSI_CYAN + "-- Thêm mới sổ tiết kiệm thành công --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Input wrong format");
        }
        // Ghi file csv
        ReadAndWrite.write(termShortArrayList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\a_thi_module2\\data\\ShortTerm.csv");

    }

    @Override
    public void addNewShortTermHasTime() {
        try {
            System.out.print("Nhập mã sổ: ");
            int idTerm = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập khách hàng: ");
            int idCustomer = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập ngày mở sổ: ");
            String dayOpenTerm = scanner.nextLine();
            System.out.print("Nhập thời gian bắt đầu gửi: ");
            String timeStartSend = scanner.nextLine();
            System.out.print("Nhập kỳ hạn: ");
            String kyHan = scanner.nextLine();
            System.out.print("Nhập số tiền: ");
            int money = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập lãi suất: ");
            double laiSuat = Double.parseDouble(scanner.nextLine());

            ShortTermHasTime shortTermHasTime = new ShortTermHasTime(idTerm, idCustomer, dayOpenTerm, timeStartSend, kyHan, money, laiSuat);
            termShortArrayList.add(shortTermHasTime);

            System.out.println(ANSI_CYAN + "-- Thêm mới sổ tiết kiệm thành công --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Input wrong format");
        }
        // Ghi file csv
        ReadAndWrite.write(termShortArrayList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\a_thi_module2\\data\\ShortTerm.csv");

    }

    @Override
    public void addNewLongTerm() {
        try {
            System.out.print("Nhập mã sổ: ");
            int idTerm = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập khách hàng: ");
            int idCustomer = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập ngày mở sổ: ");
            String dayOpenTerm = scanner.nextLine();
            System.out.print("Nhập thời gian bắt đầu gửi: ");
            String timeStartSend = scanner.nextLine();
            System.out.print("Nhập kỳ hạn: ");
            String kyHan = scanner.nextLine();
            System.out.print("Nhập số tiền: ");
            int money = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập lãi suất: ");
            double laiSuat = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập ưu đãi: ");
            String uuDai = scanner.nextLine();

            LongTerm longTerm = new LongTerm(idTerm, idCustomer, dayOpenTerm, timeStartSend, kyHan, money, laiSuat, uuDai);
            termLongArrayList.add(longTerm);

            System.out.println(ANSI_CYAN + "-- Thêm mới sổ tiết kiệm thành công --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Input wrong format");
        }
        // Ghi file csv
        ReadAndWrite.write(termLongArrayList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\a_thi_module2\\data\\LongTerm.csv");
    }

    public void deleteShortTerm() {
        System.out.print("Nhập mã sổ ngắn hạn muốn xoá: ");
        int id = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < termShortArrayList.size(); i++) {
            if (id == termShortArrayList.get(i).getIdTerm()) {
                count++;
                termShortArrayList.remove(i);
                System.out.println(ANSI_CYAN + "-- Delete successfully --" + ANSI_RESET);
            }
        }
        if (count == 0) {
            System.err.println("NOT FOUND  " + id);
        }
        // Ghi file csv
        ReadAndWrite.write(termShortArrayList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\a_thi_module2\\data\\ShortTerm.csv");

    }
    public void deleteLongTerm() {
        System.out.print("Nhập mã sổ dài hạn muốn xoá: ");
        int id = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < termLongArrayList.size(); i++) {
            if (id == termLongArrayList.get(i).getIdTerm()) {
                count++;
                termLongArrayList.remove(i);
                System.out.println(ANSI_CYAN + "-- Delete successfully --" + ANSI_RESET);
            }
        }
        if (count == 0) {
            System.err.println("NOT FOUND  " + id);
        }
        // Ghi file csv
        ReadAndWrite.write(termLongArrayList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\a_thi_module2\\data\\LongTerm.csv");

    }
}
