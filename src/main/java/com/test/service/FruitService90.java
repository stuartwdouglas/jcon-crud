package com.test.service;

import com.test.entity.Fruit90;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService90 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit90 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit90 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit90> list() {
        return entityManager.createQuery("from Fruit90").getResultList();
    }

    public Fruit90 find(int id) {
        return entityManager.find(Fruit90.class, id);
    }
}
