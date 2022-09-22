package pitch.services;

import case_study.utils.ReadAndWrite;
import pitch.models.Pitch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PitchServiceImpl implements PitchService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private List<Pitch> pitchList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void addPitch() {
        try {
            System.out.println("Nhập id sân bóng: ");
            String idPitch = scanner.nextLine();
            System.out.println("Nhập tên sân bóng: ");
            String namePitch = scanner.nextLine();
            System.out.println("Nhập diện tích sân bóng: ");
            double areaPitch = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập số người: ");
            int peopleMax = Integer.parseInt(scanner.nextLine());
            int price = inputPrice();

            Pitch pitch = new Pitch(idPitch, namePitch, areaPitch, peopleMax, price);
            pitchList.add(pitch);

            System.out.println(ANSI_CYAN + "-- Thêm mới thành công --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Nhập sai định dạng");
        }
        // Ghi file csv
        ReadAndWrite.write(pitchList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\pitch\\data\\pitch.csv");

    }

    @Override
    public void displayPitch() {
        pitchList = (List<Pitch>) pitch.utils.ReadAndWrite.read("D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\pitch\\data\\pitch.csv");
        for (Pitch pitch : pitchList) {
            System.out.println(pitch.toString());
        }
    }

    @Override
    public void deletePitch() {
        System.out.print("Nhập id sân bóng muốn xoá: ");
        String id = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < pitchList.size(); i++) {
            if (id.equals(pitchList.get(i).getIdPitch())) {
                count++;
                pitchList.remove(i);
                System.out.println(ANSI_CYAN + "-- Xoá thành công --" + ANSI_RESET);
            }
        }
        if (count == 0) {
            System.err.println("KHÔNG TÌM THẤY " + id);
        }
        // Ghi file csv
        ReadAndWrite.write(pitchList, "D:\\Codegym\\A0422I1-HoangPhucTan\\module2\\src\\pitch\\data\\pitch.csv");

    }

    @Override
    public void updatePitch() {

    }
    public List<Pitch> sendPitch() {
        return pitchList;
    }

    // validate input value
    private int inputPrice() {
        System.out.println("Nhập giá sân: ");
        int price;

        do {
            price  = Integer.parseInt(scanner.nextLine());
            if (price <= 0) {
                System.out.println("Nhập sai - Giá phải lớn hơn 0");
            }
        } while (price <= 0);

        return price;
    }
}
