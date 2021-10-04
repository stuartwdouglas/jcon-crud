package com.test.service;

import com.test.entity.Fruit69;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService69 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit69 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit69 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit69> list() {
        return entityManager.createQuery("from Fruit69").getResultList();
    }

    public Fruit69 find(int id) {
        return entityManager.find(Fruit69.class, id);
    }
}
