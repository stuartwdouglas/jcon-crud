package com.test.service;

import com.test.entity.Fruit17;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService17 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit17 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit17 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit17> list() {
        return entityManager.createQuery("from Fruit17").getResultList();
    }

    public Fruit17 find(int id) {
        return entityManager.find(Fruit17.class, id);
    }
}
