package com.test.service;

import com.test.entity.Fruit84;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService84 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit84 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit84 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit84> list() {
        return entityManager.createQuery("from Fruit84").getResultList();
    }

    public Fruit84 find(int id) {
        return entityManager.find(Fruit84.class, id);
    }
}
