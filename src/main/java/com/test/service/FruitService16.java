package com.test.service;

import com.test.entity.Fruit16;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService16 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit16 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit16 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit16> list() {
        return entityManager.createQuery("from Fruit16").getResultList();
    }

    public Fruit16 find(int id) {
        return entityManager.find(Fruit16.class, id);
    }
}
