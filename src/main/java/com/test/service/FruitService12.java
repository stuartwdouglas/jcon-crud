package com.test.service;

import com.test.entity.Fruit12;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService12 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit12 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit12 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit12> list() {
        return entityManager.createQuery("from Fruit12").getResultList();
    }

    public Fruit12 find(int id) {
        return entityManager.find(Fruit12.class, id);
    }
}
