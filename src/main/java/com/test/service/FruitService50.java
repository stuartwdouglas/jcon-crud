package com.test.service;

import com.test.entity.Fruit50;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService50 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit50 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit50 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit50> list() {
        return entityManager.createQuery("from Fruit50").getResultList();
    }

    public Fruit50 find(int id) {
        return entityManager.find(Fruit50.class, id);
    }
}
