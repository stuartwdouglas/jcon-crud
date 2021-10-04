package com.test.service;

import com.test.entity.Fruit43;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService43 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit43 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit43 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit43> list() {
        return entityManager.createQuery("from Fruit43").getResultList();
    }

    public Fruit43 find(int id) {
        return entityManager.find(Fruit43.class, id);
    }
}
