package com.test.service;

import com.test.entity.Fruit2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService2 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit2 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit2 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit2> list() {
        return entityManager.createQuery("from Fruit2").getResultList();
    }

    public Fruit2 find(int id) {
        return entityManager.find(Fruit2.class, id);
    }
}
