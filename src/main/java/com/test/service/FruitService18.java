package com.test.service;

import com.test.entity.Fruit18;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService18 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit18 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit18 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit18> list() {
        return entityManager.createQuery("from Fruit18").getResultList();
    }

    public Fruit18 find(int id) {
        return entityManager.find(Fruit18.class, id);
    }
}
