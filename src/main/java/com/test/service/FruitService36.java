package com.test.service;

import com.test.entity.Fruit36;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService36 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit36 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit36 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit36> list() {
        return entityManager.createQuery("from Fruit36").getResultList();
    }

    public Fruit36 find(int id) {
        return entityManager.find(Fruit36.class, id);
    }
}
