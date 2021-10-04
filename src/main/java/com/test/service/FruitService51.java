package com.test.service;

import com.test.entity.Fruit51;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService51 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit51 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit51 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit51> list() {
        return entityManager.createQuery("from Fruit51").getResultList();
    }

    public Fruit51 find(int id) {
        return entityManager.find(Fruit51.class, id);
    }
}
