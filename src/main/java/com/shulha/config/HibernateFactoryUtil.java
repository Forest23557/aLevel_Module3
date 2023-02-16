package com.shulha.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateFactoryUtil {
    private static EntityManagerFactory entityManagerFactory;

    private HibernateFactoryUtil() {
    }

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory =
                    Persistence.createEntityManagerFactory("persistence");
        }

        return entityManagerFactory.createEntityManager();
    }
}
