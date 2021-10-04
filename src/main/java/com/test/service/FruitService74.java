package com.test.service;

import com.test.entity.Fruit74;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService74 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit74 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit74 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit74> list() {
        return entityManager.createQuery("from Fruit74").getResultList();
    }

    public Fruit74 find(int id) {
        return entityManager.find(Fruit74.class, id);
    }
}
