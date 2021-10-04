package com.test.service;

import com.test.entity.Fruit85;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService85 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit85 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit85 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit85> list() {
        return entityManager.createQuery("from Fruit85").getResultList();
    }

    public Fruit85 find(int id) {
        return entityManager.find(Fruit85.class, id);
    }
}
