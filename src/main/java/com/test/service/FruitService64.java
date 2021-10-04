package com.test.service;

import com.test.entity.Fruit64;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService64 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit64 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit64 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit64> list() {
        return entityManager.createQuery("from Fruit64").getResultList();
    }

    public Fruit64 find(int id) {
        return entityManager.find(Fruit64.class, id);
    }
}
