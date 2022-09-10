package a_thi_module2.models;

import java.io.Serializable;

public class ShortTermNoTime extends ShortTerm implements Serializable {
    public ShortTermNoTime(int idTerm, int id_customer, String dayOpenTerm, String timeStartSend, int money, double laiSuat) {
        super(idTerm, id_customer, dayOpenTerm, timeStartSend, money, laiSuat);
    }
    @Override
    public String toString() {
        return "ShortTermNoTime{" +
                "idTerm=" + super.getIdTerm() +
                ", customer=" + super.getCustomer() +
                ", dayOpenTerm='" + super.getDayOpenTerm() + '\'' +
                ", timeStartSend='" + super.getTimeStartSend() + '\'' +
                ", money=" + super.getMoney() +
                ", laiSuat=" + super.getLaiSuat() +
                '}';
    }
}
