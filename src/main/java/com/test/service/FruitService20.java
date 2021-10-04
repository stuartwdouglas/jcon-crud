package com.test.service;

import com.test.entity.Fruit20;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService20 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit20 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit20 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit20> list() {
        return entityManager.createQuery("from Fruit20").getResultList();
    }

    public Fruit20 find(int id) {
        return entityManager.find(Fruit20.class, id);
    }
}
