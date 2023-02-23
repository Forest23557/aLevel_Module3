package com.shulha.repository;

import com.shulha.model.StudentMarkDTO;
import com.shulha.config.HibernateFactoryUtil;
import com.shulha.model.Lecturer;
import com.shulha.model.Person;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import java.util.List;

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
        return ENTITY_MANAGER.createQuery(
                        "SELECT new com.shulha.model.StudentMarkDTO(s.name, s.surname, AVG(m.mark)) " +
                                "FROM Student AS s " +
                                "JOIN s.marks AS m " +
                                "GROUP BY s.name, s.surname " +
                                "HAVING AVG(m.mark) > :lowerBound",
                        StudentMarkDTO.class
                ).setParameter("lowerBound", (double) lowerBound)
                .getResultList();
    }
}
