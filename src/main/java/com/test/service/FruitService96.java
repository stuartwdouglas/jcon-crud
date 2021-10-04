package com.test.service;

import com.test.entity.Fruit96;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService96 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit96 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit96 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit96> list() {
        return entityManager.createQuery("from Fruit96").getResultList();
    }

    public Fruit96 find(int id) {
        return entityManager.find(Fruit96.class, id);
    }
}
