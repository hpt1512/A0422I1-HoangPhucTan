package case_study.models;

public class Room extends Facility {
    private String standardRoom; // tieu chuan room

    public Room(String idFacility, String nameService, double areaUse, int rentalPrice, int rentalPeopleMax, String rentalType,
                 String standardRoom) {
        super(idFacility, nameService, areaUse, rentalPrice, rentalPeopleMax, rentalType);
        this.standardRoom = standardRoom;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String toString() {
        return "Room{" +
                " idFacility = '" + idFacility + '\'' +
                ", nameService = '" + nameService + '\'' +
                ", areaUse = " + areaUse +
                ", rentalPrice = " + rentalPrice +
                ", rentalPeopleMax = " + rentalPeopleMax +
                ", rentalType = '" + rentalType + '\'' +
                "standardHouse = '" + standardRoom + '\'' +
                '}';
    }
}
