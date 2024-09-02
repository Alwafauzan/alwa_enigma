package com.example;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.model.Matkul;
import com.example.model.Student;

public class Mainjoin {

    public static void main(String[] args) {
        // Konfigurasi Hibernate
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Matkul.class)
                .buildSessionFactory();

        // Membuat session
        Session session = factory.openSession();

        try {
            // Memulai transaksi
            session.beginTransaction();

            // Melakukan join fetch menggunakan CriteriaBuilder
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> criteria = cb.createQuery(Object[].class);
            Root<Student> root = criteria.from(Student.class);
            criteria.select(cb.array(root.get("nama"), root.join("matkuls").get("matkul_name")));

            Query<Object[]> query = session.createQuery(criteria);

            List<Object[]> results = query.getResultList();

            // Menampilkan hasil
            for (Object[] row : results) {
                System.out.println("Nama: " + row[0] + ", Mata Kuliah: " + row[1]);
            }

            // Commit transaksi
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
