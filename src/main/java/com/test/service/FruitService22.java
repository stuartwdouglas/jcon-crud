package com.test.service;

import com.test.entity.Fruit22;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService22 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit22 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit22 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit22> list() {
        return entityManager.createQuery("from Fruit22").getResultList();
    }

    public Fruit22 find(int id) {
        return entityManager.find(Fruit22.class, id);
    }
}
