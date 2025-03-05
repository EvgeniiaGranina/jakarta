package org.jakarta;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.jakarta.entity.DairyProduct;

@ApplicationScoped
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    public Repository(){}

    @Transactional
    public void saveDairyProduct(DairyProduct dairyProduct){
        entityManager.persist(dairyProduct);
    }
}
