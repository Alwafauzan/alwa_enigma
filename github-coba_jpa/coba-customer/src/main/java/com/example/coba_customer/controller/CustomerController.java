package com.example.coba_customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // create
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // read
    @GetMapping("/read")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    // read by id
    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerByid(@PathVariable String id) {
        try {
            Optional<Customer> customer = customerService.getCustomerByid(id);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // update
    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomerByid(@PathVariable(value = "id") String id,
            @RequestBody Customer customerDetails) {
        try {
            Customer updatedCustomer = customerService.updateCustomerByid(id,
                    customerDetails);
            return ResponseEntity.ok(updatedCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerByid(@PathVariable String id) {
        try {
            customerService.deleteCustomerByid(id);
            return ResponseEntity.ok("Customer with id " + id + " deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public void setCustomerService(CustomerService customerService2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCustomerService'");
    }

}
