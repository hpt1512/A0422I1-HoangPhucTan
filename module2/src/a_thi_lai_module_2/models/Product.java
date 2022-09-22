package a_thi_lai_module_2.models;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private int id;
    private String codeProduct;
    private String nameProduct;
    private int price;
    private int count;
    private String nsx;

    public Product(int id, String codeProduct, String nameProduct, int price, int count, String nsx) {
        this.id = id;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.count = count;
        this.nsx = nsx;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", codeProduct='" + codeProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", nsx='" + nsx + '\'' +
                '}';
    }
}
