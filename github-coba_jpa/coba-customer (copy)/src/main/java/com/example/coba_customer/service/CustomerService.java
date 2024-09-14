package com.example.coba_customer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.coba_customer.model.Customer;
import com.example.coba_customer.model.dto.CustomerMejatDTO;
import com.example.coba_customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    // public CustomerService(CustomerRepository customerRepository) {
    // this.customerRepository = customerRepository;
    // }

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

    // joinread
    public List<CustomerMejatDTO> getAllCustomerWithMejats() {
        List<Customer> customerList = customerRepository.findAll();

        return customerList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // joinread by id
    public CustomerMejatDTO getCustomerWithMejatsById(String id) {
        Optional<Customer> customer = customerRepository.findByid(id);
        if (customer.isPresent()) {
            return convertToDTO(customer.get());
        } else {
            throw new RuntimeException("Customer with id " + id + " not found");
        }
    }

    public CustomerMejatDTO convertToDTO(Customer customer) {
        CustomerMejatDTO dto = new CustomerMejatDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());

        List<CustomerMejatDTO.MejaDTO> mejaDTOList = customer.getMejaConnections().stream().map(meja -> {
            CustomerMejatDTO.MejaDTO mejaDTO = new CustomerMejatDTO.MejaDTO();
            mejaDTO.setId(meja.getId());
            mejaDTO.setMejaName(meja.getMejaName());
            return mejaDTO;
        }).collect(Collectors.toList());

        dto.setMejaConnections(mejaDTOList);

        return dto;
    }

}
