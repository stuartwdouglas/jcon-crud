package com.test.service;

import com.test.entity.Fruit55;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService55 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit55 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit55 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit55> list() {
        return entityManager.createQuery("from Fruit55").getResultList();
    }

    public Fruit55 find(int id) {
        return entityManager.find(Fruit55.class, id);
    }
}
