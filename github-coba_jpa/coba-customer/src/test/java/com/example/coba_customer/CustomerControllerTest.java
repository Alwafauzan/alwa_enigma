package com.example.coba_customer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.coba_customer.controller.CustomerController;
import com.example.coba_customer.model.Customer;
import com.example.coba_customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

// Anotasi WebMvcTest hanya menginisialisasi CustomerController
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllCustomers() throws Exception {
        Customer customer = new Customer();
        // customer.setId("123e4567-e89b-12d3-a456-426614174000");
        customer.setName("cust1");
        customer.setPhoneNumber("1234567890");
        customer.setIsMember(true);

        Mockito.when(customerService.getAllCustomer())
                .thenReturn(Collections.singletonList(customer));

        mockMvc.perform(get("/api/customer/read"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value("cust1"))
                .andExpect(jsonPath("$.[0].phoneNumber").value("1234567890"))
                .andExpect(jsonPath("$.[0].isMember").value(true));
    }

    // @WithMockUser
    // @Test
    // public void testSaveCustomer() throws Exception {
    // Customer customer = new Customer();
    // // customer.setId("123e4567-e89b-12d3-a456-426614174000");
    // customer.setName("cust1");
    // customer.setPhoneNumber("1234567890");
    // customer.setIsMember(true);

    // Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class)))
    // .thenReturn(customer);

    // mockMvc.perform(post("/api/customer/create")
    // .contentType(MediaType.APPLICATION_JSON)
    // .content(objectMapper.writeValueAsString(customer)))
    // // .andExpect(status().isCreated())
    // .andExpect(status().isOk())
    // .andExpect(jsonPath("$.name").value("cust1"))
    // .andExpect(jsonPath("$.phoneNumber").value("1234567890"))
    // .andExpect(jsonPath("$.isMember").value(true));
    // }

    @Test
    public void testSaveCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setName("cust1");
        customer.setPhoneNumber("1234567890");
        customer.setIsMember(true);

        Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class)))
                .thenReturn(customer);

        MvcResult result = mockMvc.perform(post("/api/customer/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("cust1"))
                .andExpect(jsonPath("$.phoneNumber").value("1234567890"))
                .andExpect(jsonPath("$.isMember").value(true))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        System.out.println("Response JSON: " + jsonResponse);
    }

    @Test
    public void testSaveCustomererror() throws Exception {
        Customer customer = new Customer();
        customer.setName("cust1");
        customer.setPhoneNumber("1234567890");
        customer.setIsMember(true);

        Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class)))
                .thenReturn(customer);

        mockMvc.perform(post("/api/customer/created")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                // .andExpect(status().isCreated())
                .andExpect(status().isNotFound());
    }
}
