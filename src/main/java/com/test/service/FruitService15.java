package com.test.service;

import com.test.entity.Fruit15;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService15 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit15 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit15 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit15> list() {
        return entityManager.createQuery("from Fruit15").getResultList();
    }

    public Fruit15 find(int id) {
        return entityManager.find(Fruit15.class, id);
    }
}
