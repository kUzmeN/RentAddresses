package com.example.vladok.rentaddresses.domain;

public class RentAddress extends BaseEntity {
    private String state;
    private String city;
    private String street;

    private int monthlyRent;

    private String landLord;

    private String moovIn;
    private String moovOut;
    private String response;

    public String getMoovIn() {
        return moovIn;
    }

    public void setMoovIn(String moovIn) {
        this.moovIn = moovIn;
    }

    public String getMoovOut() {
        return moovOut;
    }

    public void setMoovOut(String moovOut) {
        this.moovOut = moovOut;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getLandLord() {
        return landLord;
    }

    public void setLandLord(String landLord) {
        this.landLord = landLord;
    }


    @Override
    public String toString() {
        return "RentAddress{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", monthlyRent=" + monthlyRent +
                ", landLord='" + landLord + '\'' +
                ", moovIn=" + moovIn +
                ", moovOut=" + moovOut +
                ", response='" + response + '\'' +
                '}';
    }
}
