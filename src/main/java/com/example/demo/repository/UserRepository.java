package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        String query = "select p from User as p";
        TypedQuery<User> typedQuery = entityManager
                .createQuery(query, User.class);
        return typedQuery.getResultList();
    }

    public User findById(Long id) {
        String query = "select c from User as c where c.id = :id";
        TypedQuery<User> typedQuery = entityManager
                .createQuery(query, User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    public void create(User user) {
        entityManager.persist(user);
    }

    public void delete(Long id) {
        User user = findById(id);
        entityManager.remove(user);
    }
}
