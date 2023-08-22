package com.example.jeomjamoon;

public class library {
    private String id;
    private String name;
    private String address;
    private String number;
    private double latitude;
    private double longitude;
    private String opentime;

    public library(String id, String name, String address, String number, String opentime, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.opentime = opentime;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber(){
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpentime(){
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public double getLatitude(){
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
