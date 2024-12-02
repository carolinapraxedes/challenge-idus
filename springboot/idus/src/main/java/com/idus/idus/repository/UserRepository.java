package com.idus.idus.repository;

import com.idus.idus.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
}
