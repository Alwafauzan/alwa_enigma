package com.example;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.model.Customer;

public class Main {
    public static void main(String[] args) {

        // Konfigurasi Hibernate
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        // Membuat session
        Session session = factory.openSession();

        try {
            // Memulai transaksi
            session.beginTransaction();

            // Melakukan join fetch menggunakan CriteriaBuilder
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> criteria = cb.createQuery(Object[].class);
            Root<Customer> root = criteria.from(Customer.class);
            criteria.select(cb.array(root.get("customer_name"), root.get("mobile_phone_no")));

            Query<Object[]> query = session.createQuery(criteria);

            List<Object[]> results = query.getResultList();

            // Menampilkan hasil
            for (Object[] row : results) {
                System.out.println("Nama: " + row[0] + ", Nomor HP: " + row[1]);
            }

            // Commit transaksi
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
