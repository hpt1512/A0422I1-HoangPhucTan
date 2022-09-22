package pitch.models;

import java.io.Serializable;

public class BookingPitch implements Serializable {
    private String idBooking;
    private Customer customer;
    private Pitch pitch;
    private String timeStart;
    private String timeEnd;

    public BookingPitch(String idBooking, Customer customer, Pitch pitch, String timeStart, String timeEnd) {
        this.idBooking = idBooking;
        this.customer = customer;
        this.pitch = pitch;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Pitch getPitch() {
        return pitch;
    }

    public void setPitch(Pitch pitch) {
        this.pitch = pitch;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "BookingPitch{" +
                "idBooking='" + idBooking + '\'' +
                ", customer=" + customer +
                ", pitch=" + pitch +
                ", timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                '}';
    }
}
