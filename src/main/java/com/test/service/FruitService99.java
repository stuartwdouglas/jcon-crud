package com.test.service;

import com.test.entity.Fruit99;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService99 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit99 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit99 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit99> list() {
        return entityManager.createQuery("from Fruit99").getResultList();
    }

    public Fruit99 find(int id) {
        return entityManager.find(Fruit99.class, id);
    }
}
