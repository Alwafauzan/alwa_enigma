package com.example.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Student;
import com.example.util.HibernateUtil;

public class StudentDAO {

    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // public List<Student> getAllStudents() {
    // try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    // // return session.createQuery("from Student", Student.class).list();
    // return session.createQuery("from Student where id between 1 and 5",
    // Student.class).list();
    // }
    // }

    // public List<Student> getAllStudents() {
    // try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    // CriteriaBuilder cbr = session.getCriteriaBuilder();
    // CriteriaQuery<Student> ceki = cbr.createQuery(Student.class);
    // Root<Student> root = ceki.from(Student.class);

    // ceki.where(
    // cbr.and(
    // cbr.like(root.get("nama"), "m%"),
    // cbr.between(root.get("id"), 1, 3),
    // cbr.like(root.get("nama"), "%m%")));

    // return session.createQuery(ceki).getResultList();
    // }
    // }

    public List<Student> getAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cbr = session.getCriteriaBuilder();
            CriteriaQuery<Student> ceki = cbr.createQuery(Student.class);
            Root<Student> root = ceki.from(Student.class);

            return session.createQuery(ceki).getResultList();
        }
    }

    public Student getStudentById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        }
    }

    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
