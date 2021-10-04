package com.test.service;

import com.test.entity.Fruit5;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService5 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit5 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit5 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit5> list() {
        return entityManager.createQuery("from Fruit5").getResultList();
    }

    public Fruit5 find(int id) {
        return entityManager.find(Fruit5.class, id);
    }
}
