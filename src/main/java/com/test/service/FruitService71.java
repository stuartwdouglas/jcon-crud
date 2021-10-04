package com.test.service;

import com.test.entity.Fruit71;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService71 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit71 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit71 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit71> list() {
        return entityManager.createQuery("from Fruit71").getResultList();
    }

    public Fruit71 find(int id) {
        return entityManager.find(Fruit71.class, id);
    }
}
