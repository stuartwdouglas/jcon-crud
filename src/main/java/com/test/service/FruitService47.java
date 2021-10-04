package com.test.service;

import com.test.entity.Fruit47;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService47 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit47 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit47 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit47> list() {
        return entityManager.createQuery("from Fruit47").getResultList();
    }

    public Fruit47 find(int id) {
        return entityManager.find(Fruit47.class, id);
    }
}
