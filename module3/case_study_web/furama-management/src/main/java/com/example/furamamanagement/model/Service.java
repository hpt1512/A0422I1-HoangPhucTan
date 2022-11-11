package com.example.furamamanagement.model;

public class Service {
    private int id;
    private String name;
    private int area;
    private double rent_cost;
    private int peopleMax;
    private int idRentType;
    private int idServiceType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int floor;

    public Service() {
    }

    public Service(int id, String name, int area, double rent_cost, int peopleMax, int idRentType, int idServiceType, String standardRoom, String descriptionOtherConvenience, double poolArea, int floor) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.rent_cost = rent_cost;
        this.peopleMax = peopleMax;
        this.idRentType = idRentType;
        this.idServiceType = idServiceType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Service(String name, int area, double rent_cost, int peopleMax, int idRentType, int idServiceType, String standardRoom, String descriptionOtherConvenience, double poolArea, int floor) {
        this.name = name;
        this.area = area;
        this.rent_cost = rent_cost;
        this.peopleMax = peopleMax;
        this.idRentType = idRentType;
        this.idServiceType = idServiceType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getRent_cost() {
        return rent_cost;
    }

    public void setRent_cost(double rent_cost) {
        this.rent_cost = rent_cost;
    }

    public int getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(int peopleMax) {
        this.peopleMax = peopleMax;
    }

    public int getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(int idRentType) {
        this.idRentType = idRentType;
    }

    public int getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(int idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
