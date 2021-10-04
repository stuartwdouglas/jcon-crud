package com.test.service;

import com.test.entity.Fruit82;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService82 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit82 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit82 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit82> list() {
        return entityManager.createQuery("from Fruit82").getResultList();
    }

    public Fruit82 find(int id) {
        return entityManager.find(Fruit82.class, id);
    }
}
