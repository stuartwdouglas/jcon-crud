package com.test.service;

import com.test.entity.Fruit3;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService3 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit3 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit3 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit3> list() {
        return entityManager.createQuery("from Fruit3").getResultList();
    }

    public Fruit3 find(int id) {
        return entityManager.find(Fruit3.class, id);
    }
}
