package a_thi_module2.models;

import java.io.Serializable;

public abstract class Term implements Serializable {
    private int idTerm;
    private int id_customer;
    private String dayOpenTerm;
    private String timeStartSend;
    private int money;
    private double laiSuat;

    public Term(int idTerm, int id_customer, String dayOpenTerm, String timeStartSend, int money, double laiSuat) {
        this.idTerm = idTerm;
        this.id_customer = id_customer;
        this.dayOpenTerm = dayOpenTerm;
        this.timeStartSend = timeStartSend;
        this.money = money;
        this.laiSuat = laiSuat;
    }

    public int getIdTerm() {
        return idTerm;
    }

    public void setIdTerm(int idTerm) {
        this.idTerm = idTerm;
    }

    public int getCustomer() {
        return id_customer;
    }

    public void setCustomer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getDayOpenTerm() {
        return dayOpenTerm;
    }

    public void setDayOpenTerm(String dayOpenTerm) {
        this.dayOpenTerm = dayOpenTerm;
    }

    public String getTimeStartSend() {
        return timeStartSend;
    }

    public void setTimeStartSend(String timeStartSend) {
        this.timeStartSend = timeStartSend;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    @Override
    public String toString() {
        return "Term{" +
                "idTerm=" + idTerm +
                ", customer=" + id_customer +
                ", dayOpenTerm='" + dayOpenTerm + '\'' +
                ", timeStartSend='" + timeStartSend + '\'' +
                ", money=" + money +
                ", laiSuat=" + laiSuat +
                '}';
    }
}
