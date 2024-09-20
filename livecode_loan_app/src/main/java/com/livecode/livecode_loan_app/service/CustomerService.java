package com.livecode.livecode_loan_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.livecode.livecode_loan_app.model.Customer;
import com.livecode.livecode_loan_app.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    /************* ✨ Codeium Command 🌟 *************/
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /****** 6bda2018-6af8-4097-86ef-baa705b029d6 *******/

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

        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setDateOfBirth(customerDetails.getDateOfBirth());
        customer.setPhone(customerDetails.getPhone());
        customer.setStatus(customerDetails.getStatus());
        customer.setUser(customerDetails.getUser());

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
