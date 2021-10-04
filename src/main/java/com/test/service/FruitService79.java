package com.test.service;

import com.test.entity.Fruit79;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService79 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit79 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit79 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit79> list() {
        return entityManager.createQuery("from Fruit79").getResultList();
    }

    public Fruit79 find(int id) {
        return entityManager.find(Fruit79.class, id);
    }
}
