package com.test.service;

import com.test.entity.Fruit6;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService6 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit6 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit6 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit6> list() {
        return entityManager.createQuery("from Fruit6").getResultList();
    }

    public Fruit6 find(int id) {
        return entityManager.find(Fruit6.class, id);
    }
}
