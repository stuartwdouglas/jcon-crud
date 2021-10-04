package com.test.service;

import com.test.entity.Fruit65;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService65 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit65 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit65 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit65> list() {
        return entityManager.createQuery("from Fruit65").getResultList();
    }

    public Fruit65 find(int id) {
        return entityManager.find(Fruit65.class, id);
    }
}
