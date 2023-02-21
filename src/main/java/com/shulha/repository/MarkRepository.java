package com.shulha.repository;

import com.shulha.config.HibernateFactoryUtil;
import com.shulha.service.UniversityService;

import javax.persistence.EntityManager;

public class MarkRepository {
    private static final EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();
    private static MarkRepository instance;

    private MarkRepository() {
    }

    public static MarkRepository getInstance() {
        MarkRepository localInstance = instance;

        if (localInstance == null) {
            synchronized (PersonRepository.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new MarkRepository();
                }
            }
        }

        return instance;
    }
}
