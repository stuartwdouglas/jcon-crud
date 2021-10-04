package com.test.service;

import com.test.entity.Fruit46;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService46 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit46 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit46 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit46> list() {
        return entityManager.createQuery("from Fruit46").getResultList();
    }

    public Fruit46 find(int id) {
        return entityManager.find(Fruit46.class, id);
    }
}
