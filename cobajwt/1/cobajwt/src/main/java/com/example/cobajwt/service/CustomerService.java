package com.example.cobajwt.service;

import java.util.List;

import com.example.cobajwt.model.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);
}
