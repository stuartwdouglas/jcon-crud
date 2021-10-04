package com.test.service;

import com.test.entity.Fruit11;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService11 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit11 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit11 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit11> list() {
        return entityManager.createQuery("from Fruit11").getResultList();
    }

    public Fruit11 find(int id) {
        return entityManager.find(Fruit11.class, id);
    }
}
