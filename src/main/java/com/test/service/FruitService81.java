package com.test.service;

import com.test.entity.Fruit81;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService81 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit81 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit81 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit81> list() {
        return entityManager.createQuery("from Fruit81").getResultList();
    }

    public Fruit81 find(int id) {
        return entityManager.find(Fruit81.class, id);
    }
}
