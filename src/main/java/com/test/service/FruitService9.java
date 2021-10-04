package com.test.service;

import com.test.entity.Fruit9;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService9 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit9 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit9 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit9> list() {
        return entityManager.createQuery("from Fruit9").getResultList();
    }

    public Fruit9 find(int id) {
        return entityManager.find(Fruit9.class, id);
    }
}
