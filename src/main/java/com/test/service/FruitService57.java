package com.test.service;

import com.test.entity.Fruit57;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService57 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit57 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit57 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit57> list() {
        return entityManager.createQuery("from Fruit57").getResultList();
    }

    public Fruit57 find(int id) {
        return entityManager.find(Fruit57.class, id);
    }
}
