package com.test.service;

import com.test.entity.Fruit63;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService63 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit63 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit63 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit63> list() {
        return entityManager.createQuery("from Fruit63").getResultList();
    }

    public Fruit63 find(int id) {
        return entityManager.find(Fruit63.class, id);
    }
}
