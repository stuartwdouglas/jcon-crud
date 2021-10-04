package com.test.service;

import com.test.entity.Fruit39;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService39 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit39 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit39 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit39> list() {
        return entityManager.createQuery("from Fruit39").getResultList();
    }

    public Fruit39 find(int id) {
        return entityManager.find(Fruit39.class, id);
    }
}
