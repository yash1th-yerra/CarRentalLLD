package model;

public class Location {

    String address;
    int pinCode;
    String city;
    String state;
    String country;

    public Location(int pincode,String city,String state,String country){
        this.pinCode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
