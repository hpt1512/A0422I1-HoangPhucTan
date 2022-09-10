package a_thi_module2.models;

import java.io.Serializable;

public class ShortTermHasTime extends ShortTerm implements Serializable {
    private String kyHan;
    public ShortTermHasTime(int idTerm, int id_customer, String dayOpenTerm, String timeStartSend, String kyHan, int money, double laiSuat) {
        super(idTerm, id_customer, dayOpenTerm, timeStartSend, money, laiSuat);
        this.kyHan = kyHan;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return "ShortTermHasTime{" +
                "idTerm=" + super.getIdTerm() +
                ", customer=" + super.getCustomer() +
                ", dayOpenTerm='" + super.getDayOpenTerm() + '\'' +
                ", timeStartSend='" + super.getTimeStartSend() + '\'' +
                ", money=" + super.getMoney() +
                ", laiSuat=" + super.getLaiSuat() +
                "kyHan='" + kyHan + '\'' +
                '}';
    }
}
