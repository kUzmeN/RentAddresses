package com.example.vladok.rentaddresses.domain;

import org.androidannotations.annotations.EBean;

@EBean
public class RentAddress extends BaseEntity {
    private String state;
    private String city;
    private String street;
    private int monthlyRent;
    private String landLord;
    private String moveIn;
    private String moveOut;
    private String response;

    public String getMoveIn() {
        return moveIn;
    }

    public void setMoveIn(String moveIn) {
        this.moveIn = moveIn;
    }

    public String getMoveOut() {
        return moveOut;
    }

    public void setMoveOut(String moveOut) {
        this.moveOut = moveOut;
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
                ", moveIn='" + moveIn + '\'' +
                ", moveOut='" + moveOut + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
