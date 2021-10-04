package com.test.service;

import com.test.entity.Fruit77;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService77 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit77 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit77 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit77> list() {
        return entityManager.createQuery("from Fruit77").getResultList();
    }

    public Fruit77 find(int id) {
        return entityManager.find(Fruit77.class, id);
    }
}
