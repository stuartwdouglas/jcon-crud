package com.test.service;

import com.test.entity.Fruit83;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService83 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit83 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit83 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit83> list() {
        return entityManager.createQuery("from Fruit83").getResultList();
    }

    public Fruit83 find(int id) {
        return entityManager.find(Fruit83.class, id);
    }
}
