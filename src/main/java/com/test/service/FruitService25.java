package com.test.service;

import com.test.entity.Fruit25;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService25 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit25 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit25 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit25> list() {
        return entityManager.createQuery("from Fruit25").getResultList();
    }

    public Fruit25 find(int id) {
        return entityManager.find(Fruit25.class, id);
    }
}
