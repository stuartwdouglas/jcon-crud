package com.test.service;

import com.test.entity.Fruit66;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService66 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit66 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit66 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit66> list() {
        return entityManager.createQuery("from Fruit66").getResultList();
    }

    public Fruit66 find(int id) {
        return entityManager.find(Fruit66.class, id);
    }
}
