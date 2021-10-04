package com.test.service;

import com.test.entity.Fruit88;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService88 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit88 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit88 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit88> list() {
        return entityManager.createQuery("from Fruit88").getResultList();
    }

    public Fruit88 find(int id) {
        return entityManager.find(Fruit88.class, id);
    }
}
