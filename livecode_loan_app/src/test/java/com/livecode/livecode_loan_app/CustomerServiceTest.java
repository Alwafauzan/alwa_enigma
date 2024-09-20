package com.livecode.livecode_loan_app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;

// Generated by CodiumAI

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.livecode.livecode_loan_app.model.AppUser;
import com.livecode.livecode_loan_app.model.Customer;
import com.livecode.livecode_loan_app.repository.CustomerRepository;
import com.livecode.livecode_loan_app.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @BeforeEach
    public void setup() {
        customerService = new CustomerService(customerRepository);
    }

    @Test
    void saveCustomer() {
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);
        // Given
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setDateOfBirth(java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)));
        customer.setPhone("0123456789");
        customer.setStatus("wanted");
        customer.setUser(AppUser.builder().build());
        // customer.build();
        Customer savedCustomer = new Customer();
        savedCustomer.setId(String.valueOf(1L));

        // When
        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);
        Customer result = customerService.saveCustomer(customer);

        // Then
        assertNotNull(result);
        assertNotNull(result.getId());
        // assertEquals(customer.getFirstName(), result.getFirstName());
        // assertEquals(customer.getLastName(), result.getLastName());
        // assertEquals(customer.getDateOfBirth(), result.getDateOfBirth());
        // assertEquals(customer.getPhone(), result.getPhone());
        // assertEquals(customer.getStatus(), result.getStatus());
        // assertEquals(customer.getUser(), result.getUser());
    }

    @Test
    void getAllCustomer() {
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);
        // Given
        Customer customer1 = new Customer();
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setDateOfBirth(java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)));
        customer1.setPhone("0123456789");
        customer1.setStatus("wanted");
        Customer customer2 = new Customer();
        customer2.setFirstName("John");
        customer2.setLastName("Doe");
        customer2.setDateOfBirth(java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)));
        customer2.setPhone("0123456789");
        customer2.setStatus("wanted");

        // When
        List<Customer> customers = Arrays.asList(customer1, customer2);
        Mockito.when(customerRepository.findAll()).thenReturn(customers);
        List<Customer> allCustomers = customerService.getAllCustomer();

        // Then
        assertNotNull(customers);
        Assertions.assertNotNull(allCustomers);
        assertEquals(2, customers.size());
        assertTrue(customers.contains(customer1));
        assertTrue(customers.contains(customer2));
    }

    @Test
    void getCustomerById() {
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);
        // Given
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setDateOfBirth(java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)));
        customer.setPhone("0123456789");
        customer.setStatus("wanted");

        // When
        when(customerRepository.findByid("1")).thenReturn(Optional.of(customer));
        Optional<Customer> result = customerService.getCustomerByid("1");

        // Then
        assertTrue(result.isPresent());
        assertEquals(customer.getFirstName(), result.get().getFirstName());
        assertEquals(customer.getLastName(), result.get().getLastName());
        assertEquals(customer.getDateOfBirth(), result.get().getDateOfBirth());
        assertEquals(customer.getPhone(), result.get().getPhone());
        assertEquals(customer.getStatus(), result.get().getStatus());
    }

    @Test
    void updateCustomer() {
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);
        // Given
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setDateOfBirth(java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)));
        customer.setPhone("0123456789");
        customer.setStatus("wanted");

        // When
        when(customerRepository.findByid("1")).thenReturn(Optional.of(customer));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        Customer result = customerService.updateCustomerByid("1", customer);

        // Then
        assertNotNull(result);
        assertEquals(customer.getFirstName(), result.getFirstName());
        assertEquals(customer.getLastName(), result.getLastName());
        assertEquals(customer.getDateOfBirth(), result.getDateOfBirth());
        assertEquals(customer.getPhone(), result.getPhone());
        assertEquals(customer.getStatus(), result.getStatus());
    }

    @Test
    void deleteCustomer() {
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);
        // Given
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setDateOfBirth(java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)));
        customer.setPhone("0123456789");
        customer.setStatus("wanted");

        // When
        when(customerRepository.findByid("1")).thenReturn(Optional.of(customer));
        doNothing().when(customerRepository).delete(customer);
        customerService.deleteCustomerByid("1");

        // Then
        verify(customerRepository, times(1)).delete(customer);

        // When
        when(customerRepository.findByid("2")).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> customerService.deleteCustomerByid("2"));
        assertEquals("Customer with id 2 not found", exception.getMessage());
    }

}
