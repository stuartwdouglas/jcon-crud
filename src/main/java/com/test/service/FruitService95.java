package com.test.service;

import com.test.entity.Fruit95;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FruitService95 {

    @Inject
    EntityManager entityManager;

    public void save(Fruit95 fruit) {
        if (fruit.getId() == null) {
            entityManager.persist(fruit);
        } else {
            entityManager.merge(fruit);
        }
    }

    public void delete(Fruit95 fruit) {
        entityManager.remove(fruit);
    }

    @SuppressWarnings("unchecked")
    public List<Fruit95> list() {
        return entityManager.createQuery("from Fruit95").getResultList();
    }

    public Fruit95 find(int id) {
        return entityManager.find(Fruit95.class, id);
    }
}
