package com.test.service;

import com.test.entity.Fruit80;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService80 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit80 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit80 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit80> list() {
        return entityManager.createQuery("from Fruit80").getResultList();
    }

    public Fruit80 find(int id) {
        return entityManager.find(Fruit80.class, id);
    }
}
