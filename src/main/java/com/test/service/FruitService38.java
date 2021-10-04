package com.test.service;

import com.test.entity.Fruit38;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService38 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit38 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit38 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit38> list() {
        return entityManager.createQuery("from Fruit38").getResultList();
    }

    public Fruit38 find(int id) {
        return entityManager.find(Fruit38.class, id);
    }
}
