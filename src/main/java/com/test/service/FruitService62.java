package com.test.service;

import com.test.entity.Fruit62;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService62 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit62 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit62 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit62> list() {
        return entityManager.createQuery("from Fruit62").getResultList();
    }

    public Fruit62 find(int id) {
        return entityManager.find(Fruit62.class, id);
    }
}
