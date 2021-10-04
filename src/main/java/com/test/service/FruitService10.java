package com.test.service;

import com.test.entity.Fruit10;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService10 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit10 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit10 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit10> list() {
        return entityManager.createQuery("from Fruit10").getResultList();
    }

    public Fruit10 find(int id) {
        return entityManager.find(Fruit10.class, id);
    }
}
