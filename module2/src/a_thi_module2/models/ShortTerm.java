package a_thi_module2.models;

import java.io.Serializable;

public class ShortTerm extends Term implements Serializable {
    public ShortTerm(int idTerm, int id_customer, String dayOpenTerm, String timeStartSend, int money, double laiSuat) {
        super(idTerm, id_customer, dayOpenTerm, timeStartSend, money, laiSuat);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
