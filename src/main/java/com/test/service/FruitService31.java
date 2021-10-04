package com.test.service;

import com.test.entity.Fruit31;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService31 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit31 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit31 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit31> list() {
        return entityManager.createQuery("from Fruit31").getResultList();
    }

    public Fruit31 find(int id) {
        return entityManager.find(Fruit31.class, id);
    }
}
