package com.test.service;

import com.test.entity.Fruit23;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService23 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit23 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit23 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit23> list() {
        return entityManager.createQuery("from Fruit23").getResultList();
    }

    public Fruit23 find(int id) {
        return entityManager.find(Fruit23.class, id);
    }
}
