package case_study.models;

public class Customer extends Person {
    private String typeCustomer;
    private String address;

    public Customer() {

    }

    public Customer(String typeCustomer, String address) {
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public Customer(int id, String name, int age, String gender, String email,
                    String typeCustomer, String address) {
        super(id, name, age, gender, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer [ID: " + super.id + ", Name: " + super.name + ", Age: " + super.age + ", Gender: " + super.gender + ", Email: " + super.email + ", Type Customer: " + typeCustomer + ", Address: " + address + "]";
    }
}
