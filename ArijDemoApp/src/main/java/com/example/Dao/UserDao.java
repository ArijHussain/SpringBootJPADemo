package com.example.Dao;

import com.example.config.DatabaseConfig;
import com.example.model.AppUser;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;


import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Arij on 10/10/2016.
 */

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Save the user
     */
    public void create(AppUser user) {
        entityManager.persist(user);
        return;
    }


    /**
     * Delete the user
     */
    public void delete(AppUser user) {
        if (entityManager.contains(user))
            entityManager.remove(user);
        else
            entityManager.remove(entityManager.merge(user));
        return;
    }


    /**
     * Return the user with the specific userId
     */
    public AppUser getUserById(int id) {
        return (AppUser) entityManager.createQuery(
                "from AppUser where userId = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    /**
     * Update the passed user
     */
    public void update(AppUser user) {
        entityManager.merge(user);
        return;
    }
}
