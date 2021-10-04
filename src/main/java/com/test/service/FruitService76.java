package com.test.service;

import com.test.entity.Fruit76;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService76 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit76 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit76 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit76> list() {
        return entityManager.createQuery("from Fruit76").getResultList();
    }

    public Fruit76 find(int id) {
        return entityManager.find(Fruit76.class, id);
    }
}
