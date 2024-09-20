package com.livecode.livecode_loan_app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livecode.livecode_loan_app.Controllers.CustomerController;
import com.livecode.livecode_loan_app.model.Customer;
import com.livecode.livecode_loan_app.service.CustomerService;
import com.livecode.livecode_loan_app.util.JwtUtil;

// Anotasi WebMvcTest hanya menginisialisasi CustomerController
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private JwtUtil jwtUtil;

    @Test
    void testGetAllCustomers() throws Exception {
        Customer customer1 = new Customer();
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setDateOfBirth(java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)));
        customer1.setPhone("0123456789");
        customer1.setStatus("wanted");

        Mockito.when(customerService.getAllCustomer())
                .thenReturn(Collections.singletonList(customer1));

        mockMvc.perform(get("/api/customer/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].firstName").value("John"))
                .andExpect(jsonPath("$.[0].lastName").value("Doe"))
                .andExpect(jsonPath("$.[0].dateOfBirth").value("1990-01-01"))
                .andExpect(jsonPath("$.[0].phone").value("0123456789"))
                .andExpect(jsonPath("$.[0].status").value("wanted"));
    }

    @Test
    public void testSaveCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setName("cust1");
        customer.setPhoneNumber("1234567890");
        customer.setIsMember(true);

        Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class)))
                .thenReturn(customer);

        MvcResult result = mockMvc.perform(post("/api/customer/")
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
    public void testGetCustomerById() throws Exception {
        Customer customer = new Customer();
        customer.setName("cust1");
        customer.setPhoneNumber("1234567890");
        customer.setIsMember(true);

        Mockito.when(customerService.getCustomerByid("1"))
                .thenReturn(Optional.of(customer));

        mockMvc.perform(get("/api/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("cust1"))
                .andExpect(jsonPath("$.phoneNumber").value("1234567890"))
                .andExpect(jsonPath("$.isMember").value(true));
    }

    @Test
    public void testUpdateCustomerById() throws Exception {
        Customer customer = new Customer();
        customer.setName("cust1");
        customer.setPhoneNumber("1234567890");
        customer.setIsMember(true);

        Mockito.when(customerService.updateCustomerByid("1", customer))
                .thenReturn(customer);

        MvcResult result = mockMvc.perform(put("/api/customer/1")
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
    public void testDeleteCustomerById() throws Exception {
        mockMvc.perform(delete("/api/customer/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Customer with id 1 deleted"));
    }
}
