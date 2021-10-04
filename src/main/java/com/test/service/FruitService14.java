package com.test.service;

import com.test.entity.Fruit14;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService14 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit14 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit14 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit14> list() {
        return entityManager.createQuery("from Fruit14").getResultList();
    }

    public Fruit14 find(int id) {
        return entityManager.find(Fruit14.class, id);
    }
}
