package com.test.service;

import com.test.entity.Fruit68;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService68 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit68 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit68 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit68> list() {
        return entityManager.createQuery("from Fruit68").getResultList();
    }

    public Fruit68 find(int id) {
        return entityManager.find(Fruit68.class, id);
    }
}
