package com.test.service;

import com.test.entity.Fruit48;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService48 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit48 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit48 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit48> list() {
        return entityManager.createQuery("from Fruit48").getResultList();
    }

    public Fruit48 find(int id) {
        return entityManager.find(Fruit48.class, id);
    }
}
