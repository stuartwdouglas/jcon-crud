package com.test.service;

import com.test.entity.Fruit35;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService35 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit35 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit35 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit35> list() {
        return entityManager.createQuery("from Fruit35").getResultList();
    }

    public Fruit35 find(int id) {
        return entityManager.find(Fruit35.class, id);
    }
}
