package com.test.service;

import com.test.entity.Fruit75;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService75 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit75 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit75 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit75> list() {
        return entityManager.createQuery("from Fruit75").getResultList();
    }

    public Fruit75 find(int id) {
        return entityManager.find(Fruit75.class, id);
    }
}
