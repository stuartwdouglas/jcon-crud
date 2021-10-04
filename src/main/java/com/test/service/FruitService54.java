package com.test.service;

import com.test.entity.Fruit54;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService54 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit54 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit54 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit54> list() {
        return entityManager.createQuery("from Fruit54").getResultList();
    }

    public Fruit54 find(int id) {
        return entityManager.find(Fruit54.class, id);
    }
}
