package com.test.service;

import com.test.entity.Fruit8;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService8 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit8 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit8 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit8> list() {
        return entityManager.createQuery("from Fruit8").getResultList();
    }

    public Fruit8 find(int id) {
        return entityManager.find(Fruit8.class, id);
    }
}
