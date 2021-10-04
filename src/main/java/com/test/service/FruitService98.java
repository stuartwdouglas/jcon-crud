package com.test.service;

import com.test.entity.Fruit98;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService98 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit98 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit98 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit98> list() {
        return entityManager.createQuery("from Fruit98").getResultList();
    }

    public Fruit98 find(int id) {
        return entityManager.find(Fruit98.class, id);
    }
}
