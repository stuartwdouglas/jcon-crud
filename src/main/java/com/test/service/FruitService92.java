package com.test.service;

import com.test.entity.Fruit92;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService92 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit92 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit92 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit92> list() {
        return entityManager.createQuery("from Fruit92").getResultList();
    }

    public Fruit92 find(int id) {
        return entityManager.find(Fruit92.class, id);
    }
}
