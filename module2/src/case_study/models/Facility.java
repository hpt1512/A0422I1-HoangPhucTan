package case_study.models;

public abstract class Facility {
    public String idFacility;
    public String nameService;
    public double areaUse;
    public int rentalPrice; // gia cho thue
    public int rentalPeopleMax; // so luong nguoi thue
    public String rentalType; // loai cho thue

    public Facility() {

    }

    public Facility(String idFacility, String nameService, double areaUse, int rentalPrice, int rentalPeopleMax, String rentalType) {
        this.idFacility = idFacility;
        this.nameService = nameService;
        this.areaUse = areaUse;
        this.rentalPrice = rentalPrice;
        this.rentalPeopleMax = rentalPeopleMax;
        this.rentalType = rentalType;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
        this.idFacility = idFacility;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getRentalPeopleMax() {
        return rentalPeopleMax;
    }

    public void setRentalPeopleMax(int rentalPeopleMax) {
        this.rentalPeopleMax = rentalPeopleMax;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }
}
