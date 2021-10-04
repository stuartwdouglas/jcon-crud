package com.test.service;

import com.test.entity.Fruit0;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService0 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit0 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit0 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit0> list() {
        return entityManager.createQuery("from Fruit0").getResultList();
    }

    public Fruit0 find(int id) {
        return entityManager.find(Fruit0.class, id);
    }
}
