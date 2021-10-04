package com.test.service;

import com.test.entity.Fruit89;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService89 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit89 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit89 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit89> list() {
        return entityManager.createQuery("from Fruit89").getResultList();
    }

    public Fruit89 find(int id) {
        return entityManager.find(Fruit89.class, id);
    }
}
