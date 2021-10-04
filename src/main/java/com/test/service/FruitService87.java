package com.test.service;

import com.test.entity.Fruit87;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService87 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit87 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit87 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit87> list() {
        return entityManager.createQuery("from Fruit87").getResultList();
    }

    public Fruit87 find(int id) {
        return entityManager.find(Fruit87.class, id);
    }
}
