package com.test.service;

import com.test.entity.Fruit58;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService58 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit58 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit58 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit58> list() {
        return entityManager.createQuery("from Fruit58").getResultList();
    }

    public Fruit58 find(int id) {
        return entityManager.find(Fruit58.class, id);
    }
}
