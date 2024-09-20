package com.example.coba_customer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "m_customer")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "is_member")
    private Boolean isMember;

    // @OneToMany(mappedBy = "customerConnections", cascade = CascadeType.ALL, fetch
    // = FetchType.LAZY)
    // @JsonManagedReference // Mengatur bahwa sisi ini adalah "owner"
    // private List<Meja> mejaConnections;

    // @OneToMany(mappedBy = "customerConnections", cascade = CascadeType.ALL, fetch
    // = FetchType.LAZY)
    // @JsonManagedReference // Mengatur bahwa sisi ini adalah "owner"
    // private List<Transaksi> transaksiConnections;
}

// {"name":"tita","phoneNumber":"089609000732","isMember":true}
// sampe mana tadi

// import static
// org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import java.util.Collections;

// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;

// import com.example.coba_customer.controller.CustomerController;
// import com.example.coba_customer.model.Customer;
// import com.example.coba_customer.service.CustomerService;