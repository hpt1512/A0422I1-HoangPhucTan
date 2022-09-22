package a_thi_lai_module_2.models;

import java.io.Serializable;

public class ProductIn extends Product implements Serializable {
    private int priceIn;
    private String proviceIn;
    private int thueIn;

    public ProductIn(int id, String codeProduct, String nameProduct, int price, int count, String nsx, int priceIn, String proviceIn, int thueIn) {
        super(id, codeProduct, nameProduct, price, count, nsx);
        this.priceIn = priceIn;
        this.proviceIn = proviceIn;
        this.thueIn = thueIn;
    }

    public int getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(int priceIn) {
        this.priceIn = priceIn;
    }

    public String getProviceIn() {
        return proviceIn;
    }

    public void setProviceIn(String proviceIn) {
        this.proviceIn = proviceIn;
    }

    public int getThueIn() {
        return thueIn;
    }

    public void setThueIn(int thueIn) {
        this.thueIn = thueIn;
    }

    @Override
    public String toString() {
        return "ProductIn{" +
                "id=" + super.getId() +
                ", codeProduct='" + super.getCodeProduct() + '\'' +
                ", nameProduct='" + super.getNameProduct() + '\'' +
                ", price=" + super.getPrice() +
                ", count=" + super.getCount() +
                ", nsx='" + super.getNsx() + '\'' +
                "priceIn=" + priceIn +
                ", proviceIn='" + proviceIn + '\'' +
                ", thueIn=" + thueIn +
                '}';
    }
}
