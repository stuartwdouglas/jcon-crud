package com.test.service;

import com.test.entity.Fruit86;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService86 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit86 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit86 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit86> list() {
        return entityManager.createQuery("from Fruit86").getResultList();
    }

    public Fruit86 find(int id) {
        return entityManager.find(Fruit86.class, id);
    }
}
