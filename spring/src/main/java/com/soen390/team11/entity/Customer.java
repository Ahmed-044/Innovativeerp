package com.soen390.team11.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "customer")
public class Customer {
    @Id
    @GenericGenerator(name="customer_id", strategy = "com.soen390.team11.generator.CustomerIDGenerator")
    @GeneratedValue(generator="customer_id")
    private String customerID;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String province;
    @Column
    private String zip;
    @Column
    private String country;

    public Customer() {
    }

    public Customer(String firstname, String lastname, String address, String city, String zip, String country,String province) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.province=province;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
