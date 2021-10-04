package com.test.service;

import com.test.entity.Fruit49;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService49 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit49 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit49 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit49> list() {
        return entityManager.createQuery("from Fruit49").getResultList();
    }

    public Fruit49 find(int id) {
        return entityManager.find(Fruit49.class, id);
    }
}
