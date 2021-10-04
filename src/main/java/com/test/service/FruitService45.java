package com.test.service;

import com.test.entity.Fruit45;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService45 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit45 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit45 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit45> list() {
        return entityManager.createQuery("from Fruit45").getResultList();
    }

    public Fruit45 find(int id) {
        return entityManager.find(Fruit45.class, id);
    }
}
