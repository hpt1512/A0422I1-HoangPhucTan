package com.example.validateformregister.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", columnDefinition = "varchar(45)")
    @NotBlank(message = "{notempty}")
    @Size(min = 5, max = 45, message = "{name.size}")
    private String name;
    @Column(name = "age")
    @Min(value = 18, message = "{age.validate}")
    @NotNull(message = "{notempty}")
    private Integer age;
    @Column(name = "phone_number", columnDefinition = "varchar(12)")
    private String phoneNumber;
    @Column(name = "email", columnDefinition = "varchar(100)")
    private String email;
    @Column(name = "password", columnDefinition = "varchar(45)")
    @NotBlank(message = "{notempty}")
    private String password;

    public User() {
    }

    public User(Integer id, String name, Integer age, String phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
