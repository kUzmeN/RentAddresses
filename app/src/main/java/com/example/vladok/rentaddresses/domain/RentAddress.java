package com.example.vladok.rentaddresses.domain;

import java.util.Date;

public class RentAddress {
    private String state;
    private String city;
    private String street;

    private int monthlyRent;

    private String landLord;

    private Date moovIn;
    private Date moovOut;

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

    public Date getMoovIn() {
        return moovIn;
    }

    public void setMoovIn(Date moovIn) {
        this.moovIn = moovIn;
    }

    public Date getMoovOut() {
        return moovOut;
    }

    public void setMoovOut(Date moovOut) {
        this.moovOut = moovOut;
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
                '}';
    }


}
