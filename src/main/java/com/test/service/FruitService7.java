package com.test.service;

import com.test.entity.Fruit7;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService7 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit7 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit7 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit7> list() {
        return entityManager.createQuery("from Fruit7").getResultList();
    }

    public Fruit7 find(int id) {
        return entityManager.find(Fruit7.class, id);
    }
}
