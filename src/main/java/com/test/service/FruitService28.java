package com.test.service;

import com.test.entity.Fruit28;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService28 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit28 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit28 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit28> list() {
        return entityManager.createQuery("from Fruit28").getResultList();
    }

    public Fruit28 find(int id) {
        return entityManager.find(Fruit28.class, id);
    }
}
