package a_thi_module2.models;

import java.io.Serializable;

public class LongTerm extends Term implements Serializable {
    private String kyHan;
    private String uuDai;

    public LongTerm(int idTerm, int id_customer, String dayOpenTerm, String timeStartSend, String kyHan, int money, double laiSuat, String uuDai) {
        super(idTerm, id_customer, dayOpenTerm, timeStartSend, money, laiSuat);
        this.kyHan = kyHan;
        this.uuDai = uuDai;
    }


    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    @Override
    public String toString() {
        return "LongTerm{" +
                "idTerm=" + super.getIdTerm() +
                ", customer=" + super.getCustomer() +
                ", dayOpenTerm='" + super.getDayOpenTerm() + '\'' +
                ", timeStartSend='" + super.getTimeStartSend() + '\'' +
                ", money=" + super.getMoney() +
                ", laiSuat=" + super.getLaiSuat() +
                "kyHan='" + kyHan + '\'' +
                ", uuDai='" + uuDai + '\'' +
                '}';
    }
}
