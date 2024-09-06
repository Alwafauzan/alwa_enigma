package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_name")
    private String customer_name;

    @Column(name = "mobile_phone_no")
    private String mobile_phone_no;

    public Customer() {
    }

    public Customer(int id, String customer_name, String mobile_phone_no) {
        this.id = id;
        this.customer_name = customer_name;
        this.mobile_phone_no = mobile_phone_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getMobile_phone_no() {
        return mobile_phone_no;
    }

    public void setMobile_phone_no(String mobile_phone_no) {
        this.mobile_phone_no = mobile_phone_no;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", customer_name=" + customer_name + ", mobile_phone_no=" + mobile_phone_no + "]";
    }

}
