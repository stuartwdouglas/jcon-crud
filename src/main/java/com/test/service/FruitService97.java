package com.test.service;

import com.test.entity.Fruit97;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService97 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit97 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit97 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit97> list() {
        return entityManager.createQuery("from Fruit97").getResultList();
    }

    public Fruit97 find(int id) {
        return entityManager.find(Fruit97.class, id);
    }
}
