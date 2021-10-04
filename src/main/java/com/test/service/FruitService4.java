package com.test.service;

import com.test.entity.Fruit4;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService4 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit4 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit4 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit4> list() {
        return entityManager.createQuery("from Fruit4").getResultList();
    }

    public Fruit4 find(int id) {
        return entityManager.find(Fruit4.class, id);
    }
}
