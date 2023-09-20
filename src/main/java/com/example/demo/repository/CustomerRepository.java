package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> findAll() {
        String query = "select p from Customer as p";
        TypedQuery<Customer> typedQuery = entityManager
                .createQuery(query, Customer.class);
        return typedQuery.getResultList();
    }

    public Customer findById(Long id) {
        String query = "select c from Customer as c where c.id = :id";
        TypedQuery<Customer> typedQuery = entityManager
                .createQuery(query, Customer.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    public void create(Customer customer) {
        entityManager.persist(customer);
    }

    public void delete(Long id) {
        Customer customer = findById(id);
        entityManager.remove(customer);
    }
}
