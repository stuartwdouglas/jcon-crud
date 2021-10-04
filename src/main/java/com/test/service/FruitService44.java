package com.test.service;

import com.test.entity.Fruit44;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService44 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit44 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit44 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit44> list() {
        return entityManager.createQuery("from Fruit44").getResultList();
    }

    public Fruit44 find(int id) {
        return entityManager.find(Fruit44.class, id);
    }
}
