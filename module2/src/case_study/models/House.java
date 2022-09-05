package case_study.models;

public class House extends Facility {
    public House(String idFacility, String nameService, double areaUse, int rentalPrice, int rentalPeopleMax, String rentalType) {
        super(idFacility, nameService, areaUse, rentalPrice, rentalPeopleMax, rentalType);
    }
}
