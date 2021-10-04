package com.test.service;

import com.test.entity.Fruit19;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService19 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit19 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit19 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit19> list() {
        return entityManager.createQuery("from Fruit19").getResultList();
    }

    public Fruit19 find(int id) {
        return entityManager.find(Fruit19.class, id);
    }
}
