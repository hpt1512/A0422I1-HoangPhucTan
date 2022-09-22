package pitch.models;

import java.io.Serializable;

public class Pitch implements Serializable {
    private String idPitch;
    private String namePitch;
    private double areaPitch;
    private int peopleMax;
    private int price;

    public Pitch(String idPitch, String namePitch, double areaPitch, int peopleMax, int price) {
        this.idPitch = idPitch;
        this.namePitch = namePitch;
        this.areaPitch = areaPitch;
        this.peopleMax = peopleMax;
        this.price = price;
    }

    public String getIdPitch() {
        return idPitch;
    }

    public void setIdPitch(String idPitch) {
        this.idPitch = idPitch;
    }

    public String getNamePitch() {
        return namePitch;
    }

    public void setNamePitch(String namePitch) {
        this.namePitch = namePitch;
    }

    public double getAreaPitch() {
        return areaPitch;
    }

    public void setAreaPitch(double areaPitch) {
        this.areaPitch = areaPitch;
    }

    public int getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(int peopleMax) {
        this.peopleMax = peopleMax;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pitch{" +
                "idPitch='" + idPitch + '\'' +
                ", namePitch='" + namePitch + '\'' +
                ", areaPitch=" + areaPitch +
                ", peopleMax=" + peopleMax +
                ", price=" + price +
                '}';
    }
}
