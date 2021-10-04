package com.test.service;

import com.test.entity.Fruit70;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService70 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit70 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit70 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit70> list() {
        return entityManager.createQuery("from Fruit70").getResultList();
    }

    public Fruit70 find(int id) {
        return entityManager.find(Fruit70.class, id);
    }
}
