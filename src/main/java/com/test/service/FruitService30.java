package com.test.service;

import com.test.entity.Fruit30;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService30 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit30 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit30 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit30> list() {
        return entityManager.createQuery("from Fruit30").getResultList();
    }

    public Fruit30 find(int id) {
        return entityManager.find(Fruit30.class, id);
    }
}
