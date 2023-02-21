package com.shulha.repository;

import com.shulha.DTO.StudentMarkDTO;
import com.shulha.config.HibernateFactoryUtil;
import com.shulha.model.Lecturer;
import com.shulha.model.Person;
import com.shulha.model.Student;
import com.shulha.service.UniversityService;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonRepository {
    private static final EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();
    private static volatile PersonRepository instance;

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

    @SneakyThrows
    public List<Lecturer> getLecturerByNameOrSurname(final String nameOrSurname) {
        return ENTITY_MANAGER.createQuery(
                        "from Lecturer as l where l.name like :name or l.surname like :surname",
                        Lecturer.class
                ).setParameter("name", nameOrSurname)
                .setParameter("surname", nameOrSurname)
                .getResultList();
    }

    @SneakyThrows
    public List<StudentMarkDTO> getStudentsWhoseAverageMarksHigherThan(final int lowerBound) {
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT * FROM (" +
                                "SELECT p.name, p.surname, AVG(m.mark_value) AS avg_mark " +
                                "FROM person AS p " +
                                "LEFT JOIN mark AS m ON p.person_id = m.person_id " +
                                "WHERE p.employment_type = 1 " +
                                "GROUP BY p.name, p.surname " +
                                ") AS st " +
                                "WHERE st.avg_mark > ?;",
                        StudentMarkDTO.class
                ).setParameter(1, lowerBound)
                .getResultList();
    }
}
