package com.test.service;

import com.test.entity.Fruit21;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService21 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit21 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit21 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit21> list() {
        return entityManager.createQuery("from Fruit21").getResultList();
    }

    public Fruit21 find(int id) {
        return entityManager.find(Fruit21.class, id);
    }
}
