package com.test.service;

import com.test.entity.Fruit29;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService29 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit29 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit29 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit29> list() {
        return entityManager.createQuery("from Fruit29").getResultList();
    }

    public Fruit29 find(int id) {
        return entityManager.find(Fruit29.class, id);
    }
}
