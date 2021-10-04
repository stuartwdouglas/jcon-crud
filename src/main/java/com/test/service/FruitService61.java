package com.test.service;

import com.test.entity.Fruit61;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService61 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit61 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit61 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit61> list() {
        return entityManager.createQuery("from Fruit61").getResultList();
    }

    public Fruit61 find(int id) {
        return entityManager.find(Fruit61.class, id);
    }
}
