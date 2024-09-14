package com.example.coba_customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coba_customer.model.Customer;
import com.example.coba_customer.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // create
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // read
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();

    }

    // read by id
    public Optional<Customer> getCustomerByid(String id) {
        return customerRepository.findByid(id);
    }

    // update
    public Customer updateCustomerByid(String id, Customer customerDetails) {
        Customer customer = customerRepository.findByid(id)
                .orElseThrow(() -> new RuntimeException("Customer with id " + id + " not found"));

        customer.setName(customerDetails.getName());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.setIsMember(customerDetails.getIsMember());

        return customerRepository.save(customer);
    }

    // delete
    public void deleteCustomerByid(String id) {
        Optional<Customer> customer = customerRepository.findByid(id);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
        } else {
            throw new RuntimeException("Customer with id " + id + " not found");
        }
    }

}
