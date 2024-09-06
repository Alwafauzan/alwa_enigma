package com.example.coba_customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coba_customer.model.Customer;
import com.example.coba_customer.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // create
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // read
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();

    }

    // update
    public Customer updateCustomerByPhoneNumber(String phoneNumber, Customer customerDetails) {
        // Fetch the customer using the provided phoneNumber or throw an exception if
        // not found
        Customer customer = customerRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Customer with phoneNumber " + phoneNumber + " not found"));

        // Update the customer's details
        customer.setName(customerDetails.getName());
        customer.setIsMember(customerDetails.getIsMember());

        // Save and return the updated customer
        return customerRepository.save(customer);
    }

}
