package com.test.service;

import com.test.entity.Fruit27;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService27 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit27 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit27 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit27> list() {
        return entityManager.createQuery("from Fruit27").getResultList();
    }

    public Fruit27 find(int id) {
        return entityManager.find(Fruit27.class, id);
    }
}
