package com.test.service;

import com.test.entity.Fruit59;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService59 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit59 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit59 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit59> list() {
        return entityManager.createQuery("from Fruit59").getResultList();
    }

    public Fruit59 find(int id) {
        return entityManager.find(Fruit59.class, id);
    }
}
