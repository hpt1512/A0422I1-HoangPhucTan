package pitch.models;

import java.io.Serializable;

public class Customer implements Serializable {
    private String idCustomer;
    private String nameCustomer;
    private int age;
    private String address;

    public Customer(String idCustomer, String nameCustomer, int age, String address) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.age = age;
        this.address = address;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
