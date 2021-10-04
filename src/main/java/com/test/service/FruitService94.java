package com.test.service;

import com.test.entity.Fruit94;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService94 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit94 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit94 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit94> list() {
        return entityManager.createQuery("from Fruit94").getResultList();
    }

    public Fruit94 find(int id) {
        return entityManager.find(Fruit94.class, id);
    }
}
