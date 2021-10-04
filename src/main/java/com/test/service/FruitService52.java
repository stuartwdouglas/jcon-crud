package com.test.service;

import com.test.entity.Fruit52;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService52 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit52 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit52 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit52> list() {
        return entityManager.createQuery("from Fruit52").getResultList();
    }

    public Fruit52 find(int id) {
        return entityManager.find(Fruit52.class, id);
    }
}
