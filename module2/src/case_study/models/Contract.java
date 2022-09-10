package case_study.models;

public class Contract {
    private String idContract;
    private Booking booking;
    private int pre;
    private int pay;
    private Customer customer;

    public Contract(String idContract, Booking booking, int pre, int pay, Customer customer) {
        this.idContract = idContract;
        this.booking = booking;
        this.pre = pre;
        this.pay = pay;
        this.customer = customer;
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getPre() {
        return pre;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                " idContract = '" + idContract + '\'' +
                ", booking id = " + booking.getIdBooking() +
                ", facility id = " + booking.getFacility().getIdFacility() +
                ", pre = " + pre +
                ", pay = " + pay +
                ", customer id = " + customer.getId() +
                '}';
    }
}
