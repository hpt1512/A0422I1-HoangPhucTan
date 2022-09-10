package case_study.services;

import case_study.models.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private int count_idVilla = 1;
    private int count_idHouse = 1;
    private int count_idRoom = 1;
    @Override
    public void display() {
        List<Contract> contractList = new ContractServiceImpl().sendContract();
        for (Contract contract : contractList) {
            int count = 0;
            for (Map.Entry<Facility, Integer> facilityEntry : facilityIntegerMap.entrySet()) {
                if (contract.getBooking().getFacility().equals(facilityEntry.getKey())) {
                    count++;
                }
                facilityEntry.setValue(count);
            }
        }

        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println(element.getKey().toString() + " - Number of rentals: " + element.getValue());
        }
    }

    @Override
    public void displayMaintain() {

    }

    public Map<Facility, Integer> sendFacility() {
        return facilityIntegerMap;
    }

    @Override
    public void addNewVilla() {
        String idVilla = "VL" + count_idVilla++;
        try {
            System.out.print("Enter name: ");
            String nameService = scanner.nextLine();
            System.out.print("Enter area use: ");
            double areaUse = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter rental price: ");
            int rentalPrice = scanner.nextInt();
            System.out.print("Enter rental people max: ");
            int rentalPeopleMax = scanner.nextInt();
            System.out.print("Enter rental type: ");
            scanner.nextLine();
            String rentalType = scanner.nextLine();
            System.out.print("Enter standard villa: ");
            String standardVilla = scanner.nextLine();
            System.out.print("Enter area pool: ");
            double areaPool = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter floor: ");
            int floor = Integer.parseInt(scanner.nextLine());

            Villa villa = new Villa(idVilla, nameService, areaUse, rentalPrice, rentalPeopleMax, rentalType, standardVilla, areaPool, floor);
            facilityIntegerMap.put(villa, 0);

            System.out.println(ANSI_CYAN + "-- Add successfully --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Input wrong format");
        }
    }


    @Override
    public void addNewHouse() {
        String idHouse = "H" + count_idHouse++;
        try {
            System.out.print("Enter name: ");
            String nameService = scanner.nextLine();
            System.out.print("Enter area use: ");
            double areaUse = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter rental price: ");
            int rentalPrice = scanner.nextInt();
            System.out.print("Enter rental people max: ");
            int rentalPeopleMax = scanner.nextInt();
            System.out.print("Enter rental type: ");
            scanner.nextLine();
            String rentalType = scanner.nextLine();
            System.out.print("Enter standard house: ");
            String standardHouse = scanner.nextLine();
            System.out.print("Enter floor: ");
            int floor = Integer.parseInt(scanner.nextLine());

            House house = new House(idHouse, nameService, areaUse, rentalPrice, rentalPeopleMax, rentalType, standardHouse, floor);
            facilityIntegerMap.put(house, 0);

            System.out.println(ANSI_CYAN + "-- Add successfully --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Input wrong format");
        }
    }

    @Override
    public void addNewRoom() {
        String idRoom = "R" + count_idRoom++;
        try {
            System.out.print("Enter name: ");
            String nameService = scanner.nextLine();
            System.out.print("Enter area use: ");
            double areaUse = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter rental price: ");
            int rentalPrice = scanner.nextInt();
            System.out.print("Enter rental people max: ");
            int rentalPeopleMax = scanner.nextInt();
            System.out.print("Enter rental type: ");
            scanner.nextLine();
            String rentalType = scanner.nextLine();
            System.out.print("Enter standard room: ");
            String standardRoom = scanner.nextLine();

            Room room = new Room(idRoom, nameService, areaUse, rentalPrice, rentalPeopleMax, rentalType, standardRoom);
            facilityIntegerMap.put(room, 0);

            System.out.println(ANSI_CYAN + "-- Add successfully --" + ANSI_RESET);
        } catch (Exception e) {
            System.err.println("Input wrong format");
        }
    }
}
