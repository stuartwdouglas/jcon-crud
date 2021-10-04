package com.test.service;

import com.test.entity.Fruit72;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService72 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit72 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit72 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit72> list() {
        return entityManager.createQuery("from Fruit72").getResultList();
    }

    public Fruit72 find(int id) {
        return entityManager.find(Fruit72.class, id);
    }
}
