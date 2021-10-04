package com.test.service;

import com.test.entity.Fruit40;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService40 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit40 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit40 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit40> list() {
        return entityManager.createQuery("from Fruit40").getResultList();
    }

    public Fruit40 find(int id) {
        return entityManager.find(Fruit40.class, id);
    }
}
