package com.husna.ogrenciserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESSES_SEQ_GENERATOR")
    @SequenceGenerator(name = "ADDRESSES_SEQ_GENERATOR", sequenceName = "ADDRESSES_SEQ", allocationSize = 1)
    @Column(name = "ADDRESS_ID")
    private int addressId;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    public Address() {
    }

    public Address(String address, String city, String state, String country,String postalCode) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
