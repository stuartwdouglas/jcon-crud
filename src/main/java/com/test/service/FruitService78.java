package com.test.service;

import com.test.entity.Fruit78;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService78 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit78 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit78 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit78> list() {
        return entityManager.createQuery("from Fruit78").getResultList();
    }

    public Fruit78 find(int id) {
        return entityManager.find(Fruit78.class, id);
    }
}
