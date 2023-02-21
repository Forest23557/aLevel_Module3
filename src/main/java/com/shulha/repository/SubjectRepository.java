package com.shulha.repository;

import com.shulha.config.HibernateFactoryUtil;
import com.shulha.service.UniversityService;

import javax.persistence.EntityManager;

public class SubjectRepository {
    private static final EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();
    private static SubjectRepository instance;

    private SubjectRepository() {
    }

    public static SubjectRepository getInstance() {
        SubjectRepository localInstance = instance;

        if (localInstance == null) {
            synchronized (PersonRepository.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new SubjectRepository();
                }
            }
        }

        return instance;
    }
}
