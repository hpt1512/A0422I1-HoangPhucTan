package a_thi_lai_module_2.models;

import java.io.Serializable;

public class ProductOut extends Product implements Serializable {
    private int priceOut;
    private String countryOut;

    public ProductOut(int id, String codeProduct, String nameProduct, int price, int count, String nsx, int priceOut, String countryOut) {
        super(id, codeProduct, nameProduct, price, count, nsx);
        this.priceOut = priceOut;
        this.countryOut = countryOut;
    }

    public int getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(int priceOut) {
        this.priceOut = priceOut;
    }

    public String getCountryOut() {
        return countryOut;
    }

    public void setCountryOut(String countryOut) {
        this.countryOut = countryOut;
    }

    @Override
    public String toString() {
        return "ProductOut{" +
                "id=" + super.getId() +
                ", codeProduct='" + super.getCodeProduct() + '\'' +
                ", nameProduct='" + super.getNameProduct() + '\'' +
                ", price=" + super.getPrice() +
                ", count=" + super.getCount() +
                ", nsx='" + super.getNsx() + '\'' +
                "priceOut=" + priceOut +
                ", countryOut='" + countryOut + '\'' +
                '}';
    }
}
