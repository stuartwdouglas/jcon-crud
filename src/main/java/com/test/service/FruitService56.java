package com.test.service;

import com.test.entity.Fruit56;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService56 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit56 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit56 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit56> list() {
        return entityManager.createQuery("from Fruit56").getResultList();
    }

    public Fruit56 find(int id) {
        return entityManager.find(Fruit56.class, id);
    }
}
