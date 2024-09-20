package com.livecode.livecode_loan_app.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.livecode.livecode_loan_app.model.Customer;
import com.livecode.livecode_loan_app.service.CustomerService;

// ini buat inisialisasi bikin api nya
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // create
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // read
    @GetMapping("/")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    // read by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerByid(@PathVariable String id) {
        Optional<Customer> customer = customerService.getCustomerByid(id);
        return ResponseEntity.ok(customer);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomerByid(@PathVariable(value = "id") String id,
            @RequestBody Customer customerDetails) {
        Customer updatedCustomer = customerService.updateCustomerByid(id,
                customerDetails);
        return ResponseEntity.ok(updatedCustomer);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerByid(@PathVariable String id) {
        customerService.deleteCustomerByid(id);
        return ResponseEntity.ok("Customer with id " + id + " deleted");
    }

}
