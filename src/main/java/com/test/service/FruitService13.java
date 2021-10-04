package com.test.service;

import com.test.entity.Fruit13;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService13 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit13 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit13 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit13> list() {
        return entityManager.createQuery("from Fruit13").getResultList();
    }

    public Fruit13 find(int id) {
        return entityManager.find(Fruit13.class, id);
    }
}
