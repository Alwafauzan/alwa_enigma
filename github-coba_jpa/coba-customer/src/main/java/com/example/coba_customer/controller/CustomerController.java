package com.example.coba_customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coba_customer.model.Customer;
import com.example.coba_customer.service.CustomerService;

// ini buat inisialisasi bikin api nya
@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // create
    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // read
    @GetMapping
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PutMapping("/{phoneNumber}")
    public ResponseEntity<Customer> updateCustomerByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber,
            @RequestBody Customer customerDetails) {
        try {
            Customer updatedCustomer = customerService.updateCustomerByPhoneNumber(phoneNumber, customerDetails);
            return ResponseEntity.ok().body(updatedCustomer);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
