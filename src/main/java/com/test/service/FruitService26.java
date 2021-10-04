package com.test.service;

import com.test.entity.Fruit26;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService26 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit26 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit26 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit26> list() {
        return entityManager.createQuery("from Fruit26").getResultList();
    }

    public Fruit26 find(int id) {
        return entityManager.find(Fruit26.class, id);
    }
}
