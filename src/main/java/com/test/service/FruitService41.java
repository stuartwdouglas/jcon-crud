package com.test.service;

import com.test.entity.Fruit41;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService41 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit41 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit41 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit41> list() {
        return entityManager.createQuery("from Fruit41").getResultList();
    }

    public Fruit41 find(int id) {
        return entityManager.find(Fruit41.class, id);
    }
}
