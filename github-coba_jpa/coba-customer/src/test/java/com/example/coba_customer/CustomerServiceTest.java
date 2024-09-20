package com.example.coba_customer;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.coba_customer.model.Customer;
import com.example.coba_customer.model.Meja;
import com.example.coba_customer.model.Transaksi;
import com.example.coba_customer.repository.CustomerRepository;
import com.example.coba_customer.repository.MejaRepository;
import com.example.coba_customer.repository.TransaksiRepository;
import com.example.coba_customer.service.CustomerService;
import com.example.coba_customer.service.MejaService;
import com.example.coba_customer.service.TransaksiService;

public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    // serpis
    @Test
    public void transaksi_ajah() {
        var transaksiRepo = Mockito.mock(TransaksiRepository.class);
        var customerRepository = Mockito.mock(CustomerRepository.class);
        var mejaRepository = Mockito.mock(MejaRepository.class);
        var transaksiService = new TransaksiService(transaksiRepo);
        var customerService = new CustomerService(customerRepository);
        var mejaService = new MejaService(mejaRepository);

        var transaksi = new Transaksi();
        transaksi.setJumlahTransaksi(null);
        transaksi.setCustomerConnections(null);
        transaksi.setMejaConnections(null);

        List<Transaksi> transaksis = Arrays.asList(transaksi, transaksi);

        Mockito.when(transaksiRepo.findAll()).thenReturn(transaksis);

        List<Transaksi> alltransaksis = transaksiService.getAllTransaksis();

        Assertions.assertEquals(null, alltransaksis.get(0).getJumlahTransaksi());
        Assertions.assertNotNull(alltransaksis);

        var customer = new Customer();
        var meja = new Meja();

    }

    @Test
    public void test_get_all_customers_successfully() {
        var customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer1 = new Customer();
        customer1.setName("cust1");
        customer1.setPhoneNumber("1234567890");
        customer1.setIsMember(true);

        Customer customer2 = new Customer();
        customer2.setName("cust2");
        customer2.setPhoneNumber("0987654321");
        customer2.setIsMember(false);

        List<Customer> customers = Arrays.asList(customer1, customer2);

        Mockito.when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> allCustomers = customerService.getAllCustomer();

        Assertions.assertNotNull(allCustomers);
        Assertions.assertEquals(2, allCustomers.size());
        Assertions.assertEquals("cust1", allCustomers.get(0).getName());
        Assertions.assertEquals("1234567890", allCustomers.get(0).getPhoneNumber());
        Assertions.assertTrue(allCustomers.get(0).getIsMember());
        Assertions.assertEquals("cust2", allCustomers.get(1).getName());
        Assertions.assertEquals("0987654321", allCustomers.get(1).getPhoneNumber());
        Assertions.assertFalse(allCustomers.get(1).getIsMember());

        Mockito.verify(customerRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void test_get_customer_by_id_successfully() {
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = new Customer();
        customer.setName("cust1");
        customer.setPhoneNumber("1234567890");
        customer.setIsMember(true);

        Mockito.when(customerRepository.findByid("1234567890")).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.getCustomerByid("1234567890");

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("cust1", result.get().getName());
        Assertions.assertEquals("1234567890", result.get().getPhoneNumber());
        Assertions.assertTrue(result.get().getIsMember());

        Mockito.verify(customerRepository, Mockito.times(1)).findByid("1234567890");
    }

    @Test
    // @DisplayName("sdffdfv")
    public void test_get_all_customers_throws_exception() {
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);

        Mockito.when(customerRepository.findAll()).thenReturn(Collections.emptyList());

        List<Customer> allCustomers = customerService.getAllCustomer();

        Mockito.verify(customerRepository, Mockito.times(1)).findAll();

        assertTrue(allCustomers.isEmpty());
    }

    @Test
    public void test_get_customer_by_id_throws_exception() {
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);

        Mockito.when(customerRepository.findByid("1234567890")).thenReturn(Optional.empty());

        Optional<Customer> result = customerService.getCustomerByid("1234567890");

        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isPresent());

        Mockito.verify(customerRepository, Mockito.times(1)).findByid("1234567890");
    }

    @Test
    public void test_retrieve_customer_invalid_id() {
        CustomerRepository customerRepository = mock(CustomerRepository.class);

        when(customerRepository.findByid(anyString())).thenReturn(Optional.empty());

        CustomerService customerService = new CustomerService(customerRepository);

        Optional<Customer> result = customerService.getCustomerByid("invalid_id");

        assertEquals(Optional.empty(), result);
    }

    @Test
    public void test_update_customer_invalid_id() {
        CustomerRepository customerRepository = mock(CustomerRepository.class);

        // invalid ID
        when(customerRepository.findByid(anyString())).thenReturn(Optional.empty());

        CustomerService customerService = new CustomerService(customerRepository);

        assertThrows(RuntimeException.class, () -> {
            customerService.updateCustomerByid("invalid_id", new Customer());
        });
    }

    @Test
    public void test_delete_customer_invalid_id() {
        CustomerRepository customerRepository = mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);
        String invalidId = "invalid_id";

        when(customerRepository.findByid(invalidId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            // Act
            customerService.deleteCustomerByid(invalidId);
        });
    }

    @Test
    public void test_save_customer_successfully() {
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = new Customer();
        customer.setName("cust1");
        customer.setPhoneNumber("1234567890");
        customer.setIsMember(true);

        Mockito.when(customerRepository.save(customer)).thenReturn(customer);

        Customer savedCustomer = customerService.saveCustomer(customer);

        Assertions.assertNotNull(savedCustomer);
        Assertions.assertEquals("cust1", savedCustomer.getName());
        Assertions.assertEquals("1234567890", savedCustomer.getPhoneNumber());
        Assertions.assertTrue(savedCustomer.getIsMember());

        Mockito.verify(customerRepository, Mockito.times(1)).save(customer);
    }

    /************* ✨ Codeium Command 🌟 *************/
    /****** 4a9a8e32-59cd-4591-a1f4-fd96ec3555c5 *******/
    // @Test
    // public void test_save_null_customer_throws_exception() {
    // CustomerRepository customerRepository =
    // Mockito.mock(CustomerRepository.class);
    // CustomerService customerService = new CustomerService(customerRepository);

    // Assertions.assertThrows(IllegalArgumentException.class, () -> {
    // customerService.saveCustomer(null);
    // });

    // Mockito.verify(customerRepository,
    // Mockito.never()).save(Mockito.any(Customer.class));
    // }

    // Retrieving all customers successfully
    // @Test
    // public void test_retrieving_all_customers() {
    // List<Customer> customers = new ArrayList<>();
    // customers.add(new Customer("1", "Alice", "12345", true));
    // customers.add(new Customer("2", "Bob", "67890", false));

    // CustomerRepository customerRepository = mock(CustomerRepository.class);
    // when(customerRepository.findAll()).thenReturn(customers);

    // CustomerService customerService = new CustomerService(customerRepository);

    // List<Customer> retrievedCustomers = customerService.getAllCustomer();

    // assertEquals(2, retrievedCustomers.size());
    // assertEquals("Alice", retrievedCustomers.get(0).getName());
    // assertEquals("Bob", retrievedCustomers.get(1).getName());
    // }

    // Retrieving a customer by a valid ID successfully
    // @Test
    // public void test_retrieving_customer_by_id() {
    // Customer sampleCustomer = new Customer("1", "Alice", "12345", true);

    // CustomerRepository customerRepository = mock(CustomerRepository.class);
    // when(customerRepository.findByid("1")).thenReturn(Optional.of(sampleCustomer));

    // CustomerService customerService = new CustomerService(customerRepository);

    // Optional<Customer> retrievedCustomer = customerService.getCustomerByid("1");

    // assertTrue(retrievedCustomer.isPresent());
    // assertEquals("Alice", retrievedCustomer.get().getName());
    // }

    // Updating a customer by a valid ID successfully
    // @Test
    // public void test_updating_customer_success() {
    // Customer customer = new Customer("1", "Alice", "1234567890", true);

    // when(customerRepository.findByid("1")).thenReturn(Optional.of(customer));

    // Customer updatedCustomer = new Customer("1", "Alice Updated", "9876543210",
    // false);
    // Customer updatedCustomerSaved = new Customer("1", "Alice Updated",
    // "9876543210", false);
    // when(customerRepository.save(updatedCustomer)).thenReturn(updatedCustomerSaved);

    // Customer result = customerService.updateCustomerByid("1", updatedCustomer);

    // assertEquals("Alice Updated", result.getName());
    // assertEquals("9876543210", result.getPhoneNumber());
    // assertFalse(result.getIsMember());
    // }

    // Deleting a customer by a valid ID successfully
    // @Test
    // public void test_deleting_customer_success() {
    // Customer customer = new Customer("1", "Alice", "1234567890", true);

    // when(customerRepository.findByid("1")).thenReturn(Optional.of(customer));

    // customerService.deleteCustomerByid("1");

    // verify(customerRepository, times(1)).delete(customer);
    // }

    // Retrieving a customer by an invalid ID should return Optional.empty

}
