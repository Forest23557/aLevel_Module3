package com.shulha.repository;

import com.shulha.DTO.MinMaxMarkDTO;
import com.shulha.config.HibernateFactoryUtil;
import com.shulha.service.UniversityService;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import java.util.List;

public class SubjectRepository {
    private static final EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();
    private static volatile SubjectRepository instance;

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

    @SneakyThrows
    public List<MinMaxMarkDTO> getSubjectsWithTheWorstAndTheBestResults() {
        return ENTITY_MANAGER.createNativeQuery(
                "(SELECT s.subject_name, " +
                        "AVG(m.mark_value) AS avg_mark " +
                        "FROM subject AS s " +
                        "LEFT JOIN mark AS m ON s.id = m.subject_id " +
                        "GROUP BY s.subject_name " +
                        "ORDER BY avg_mark " +
                        "LIMIT 1) " +
                        "UNION " +
                        "(SELECT s.subject_name, " +
                        "AVG(m.mark_value) AS avg_mark " +
                        "FROM subject AS s " +
                        "LEFT JOIN mark AS m ON s.id = m.subject_id " +
                        "GROUP BY s.subject_name " +
                        "ORDER BY avg_mark DESC " +
                        "LIMIT 1);",
                MinMaxMarkDTO.class
        ).getResultList();
    }
}
