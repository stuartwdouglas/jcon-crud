package com.test.service;

import com.test.entity.Fruit37;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService37 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit37 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit37 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit37> list() {
        return entityManager.createQuery("from Fruit37").getResultList();
    }

    public Fruit37 find(int id) {
        return entityManager.find(Fruit37.class, id);
    }
}
