package case_study.models;

public class Villa extends Facility {
    private String standardVilla; // tieu chuan villa
    private double areaPool; // dien tich ho boi
    private int floor; // so tang

    public Villa() {

    }

    public Villa(String idFacility, String nameService, double areaUse, int rentalPrice, int rentalPeopleMax, String rentalType,
                 String standardVilla, double areaPool, int floor ) {
        super(idFacility, nameService, areaUse, rentalPrice, rentalPeopleMax, rentalType);
        this.standardVilla = standardVilla;
        this.areaPool = areaPool;
        this.floor = floor;
    }

    public String getStandardVilla() {
        return standardVilla;
    }

    public void setStandardVilla(String standardVilla) {
        this.standardVilla = standardVilla;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                " idFacility = '" + idFacility + '\'' +
                ", nameService = '" + nameService + '\'' +
                ", areaUse = " + areaUse +
                ", rentalPrice = " + rentalPrice +
                ", rentalPeopleMax = " + rentalPeopleMax +
                ", rentalType = '" + rentalType + '\'' +
                "standardVilla = '" + standardVilla + '\'' +
                ", areaPool = " + areaPool +
                ", floor = " + floor +
                '}';
    }
}
