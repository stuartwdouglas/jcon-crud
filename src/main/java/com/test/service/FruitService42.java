package com.test.service;

import com.test.entity.Fruit42;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService42 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit42 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit42 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit42> list() {
        return entityManager.createQuery("from Fruit42").getResultList();
    }

    public Fruit42 find(int id) {
        return entityManager.find(Fruit42.class, id);
    }
}
