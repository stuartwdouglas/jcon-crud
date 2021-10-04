package com.test.service;

import com.test.entity.Fruit32;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService32 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit32 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit32 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit32> list() {
        return entityManager.createQuery("from Fruit32").getResultList();
    }

    public Fruit32 find(int id) {
        return entityManager.find(Fruit32.class, id);
    }
}
