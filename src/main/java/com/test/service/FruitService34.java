package com.test.service;

import com.test.entity.Fruit34;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService34 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit34 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit34 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit34> list() {
        return entityManager.createQuery("from Fruit34").getResultList();
    }

    public Fruit34 find(int id) {
        return entityManager.find(Fruit34.class, id);
    }
}
