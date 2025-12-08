package com.example.gameapp;

public class Player {
    private int playerId;
    private String firstName, lastName, address, postalCode, province, phone;

    // Constructor for insert (no ID)
    public Player(String firstName, String lastName, String address, String postalCode, String province, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.province = province;
        this.phone = phone;
    }

    // Constructor for update (with ID)
    public Player(int playerId, String firstName, String lastName, String address, String postalCode, String province, String phone) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.province = province;
        this.phone = phone;
    }

    public int getPlayerId() { return playerId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getPostalCode() { return postalCode; }
    public String getProvince() { return province; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return firstName + " " + lastName; // so ComboBox shows clean names
    }
}
