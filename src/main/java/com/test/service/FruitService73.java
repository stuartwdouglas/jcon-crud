package com.test.service;

import com.test.entity.Fruit73;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService73 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit73 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit73 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit73> list() {
        return entityManager.createQuery("from Fruit73").getResultList();
    }

    public Fruit73 find(int id) {
        return entityManager.find(Fruit73.class, id);
    }
}
