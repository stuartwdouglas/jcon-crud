package com.test.service;

import com.test.entity.Fruit1;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService1 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit1 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit1 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit1> list() {
        return entityManager.createQuery("from Fruit1").getResultList();
    }

    public Fruit1 find(int id) {
        return entityManager.find(Fruit1.class, id);
    }
}
