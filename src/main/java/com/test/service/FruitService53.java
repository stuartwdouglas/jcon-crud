package com.test.service;

import com.test.entity.Fruit53;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService53 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit53 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit53 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit53> list() {
        return entityManager.createQuery("from Fruit53").getResultList();
    }

    public Fruit53 find(int id) {
        return entityManager.find(Fruit53.class, id);
    }
}
