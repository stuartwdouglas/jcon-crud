package com.test.service;

import com.test.entity.Fruit93;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService93 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit93 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit93 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit93> list() {
        return entityManager.createQuery("from Fruit93").getResultList();
    }

    public Fruit93 find(int id) {
        return entityManager.find(Fruit93.class, id);
    }
}
