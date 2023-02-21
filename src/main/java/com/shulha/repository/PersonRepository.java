package com.shulha.repository;

import com.shulha.config.HibernateFactoryUtil;
import com.shulha.model.Person;
import com.shulha.model.Student;
import com.shulha.service.UniversityService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PersonRepository {
    private static final EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();
    private static PersonRepository instance;

    private PersonRepository() {
    }

    public static PersonRepository getInstance() {
        PersonRepository localInstance = instance;

        if (localInstance == null) {
            synchronized (PersonRepository.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new PersonRepository();
                }
            }
        }

        return instance;
    }

    public void save(final Person person) {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.persist(person);
        ENTITY_MANAGER.flush();
        ENTITY_MANAGER.getTransaction().commit();
    }
}
