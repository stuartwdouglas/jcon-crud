package com.test.service;

import com.test.entity.Fruit33;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService33 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit33 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit33 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit33> list() {
        return entityManager.createQuery("from Fruit33").getResultList();
    }

    public Fruit33 find(int id) {
        return entityManager.find(Fruit33.class, id);
    }
}
