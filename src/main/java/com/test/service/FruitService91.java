package com.test.service;

import com.test.entity.Fruit91;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService91 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit91 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit91 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit91> list() {
        return entityManager.createQuery("from Fruit91").getResultList();
    }

    public Fruit91 find(int id) {
        return entityManager.find(Fruit91.class, id);
    }
}
