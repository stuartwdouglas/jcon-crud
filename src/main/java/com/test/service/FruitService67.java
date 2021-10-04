package com.test.service;

import com.test.entity.Fruit67;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService67 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit67 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit67 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit67> list() {
        return entityManager.createQuery("from Fruit67").getResultList();
    }

    public Fruit67 find(int id) {
        return entityManager.find(Fruit67.class, id);
    }
}
