package case_study.models;

public class House extends Facility {
    private String standardHouse; // tieu chuan house
    private int floor; // so tang
    public House(String idFacility, String nameService, double areaUse, int rentalPrice, int rentalPeopleMax, String rentalType,
                 String standardHouse, int floor ) {
        super(idFacility, nameService, areaUse, rentalPrice, rentalPeopleMax, rentalType);
        this.standardHouse = standardHouse;
        this.floor = floor;
    }

    public String getStandardHouse() {
        return standardHouse;
    }

    public void setStandardHouse(String standardHouse) {
        this.standardHouse = standardHouse;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    public String toString() {
        return "House{" +
                " idFacility = '" + idFacility + '\'' +
                ", nameService = '" + nameService + '\'' +
                ", areaUse = " + areaUse +
                ", rentalPrice = " + rentalPrice +
                ", rentalPeopleMax = " + rentalPeopleMax +
                ", rentalType = '" + rentalType + '\'' +
                "standardHouse = '" + standardHouse + '\'' +
                ", floor = " + floor +
                '}';
    }
}
