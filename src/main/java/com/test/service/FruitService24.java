package com.test.service;

import com.test.entity.Fruit24;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService24 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit24 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit24 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit24> list() {
        return entityManager.createQuery("from Fruit24").getResultList();
    }

    public Fruit24 find(int id) {
        return entityManager.find(Fruit24.class, id);
    }
}
