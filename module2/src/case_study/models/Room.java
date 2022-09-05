package case_study.models;

public class Room extends Facility {
    public Room(String idFacility, String nameService, double areaUse, int rentalPrice, int rentalPeopleMax, String rentalType) {
        super(idFacility, nameService, areaUse, rentalPrice, rentalPeopleMax, rentalType);
    }
}
