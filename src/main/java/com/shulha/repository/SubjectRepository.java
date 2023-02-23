package com.shulha.repository;

import com.shulha.model.MinMaxMarkDTO;
import com.shulha.config.HibernateFactoryUtil;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import java.util.ArrayList;
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
        final List<MinMaxMarkDTO> minMaxMarkDTOList = new ArrayList<>();

        final MinMaxMarkDTO min = ENTITY_MANAGER.createQuery(
                        "SELECT new com.shulha.model.MinMaxMarkDTO(s.subject, AVG(m.mark)) " +
                                "FROM Mark AS m " +
                                "JOIN m.subject AS s " +
                                "GROUP BY s.subject " +
                                "ORDER BY AVG(m.mark)",
                        MinMaxMarkDTO.class
                ).setMaxResults(1)
                .getSingleResult();

        final MinMaxMarkDTO max = ENTITY_MANAGER.createQuery(
                        "SELECT new com.shulha.model.MinMaxMarkDTO(s.subject, AVG(m.mark)) " +
                                "FROM Mark AS m " +
                                "JOIN m.subject AS s " +
                                "GROUP BY s.subject " +
                                "ORDER BY AVG(m.mark) DESC",
                        MinMaxMarkDTO.class
                ).setMaxResults(1)
                .getSingleResult();

        minMaxMarkDTOList.add(0, min);
        minMaxMarkDTOList.add(1, max);

        return minMaxMarkDTOList;
    }
}
