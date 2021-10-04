package com.test.service;

import com.test.entity.Fruit60;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService60 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit60 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit60 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit60> list() {
        return entityManager.createQuery("from Fruit60").getResultList();
    }

    public Fruit60 find(int id) {
        return entityManager.find(Fruit60.class, id);
    }
}
