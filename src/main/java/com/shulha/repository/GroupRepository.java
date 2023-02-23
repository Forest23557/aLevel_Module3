package com.shulha.repository;

import com.shulha.model.GroupMarkDTO;
import com.shulha.model.StudentGroupDTO;
import com.shulha.config.HibernateFactoryUtil;
import com.shulha.enums.Groups;
import com.shulha.model.Group;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class GroupRepository {
    private static final EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();
    private static volatile GroupRepository instance;

    private GroupRepository() {
    }

    public static GroupRepository getInstance() {
        GroupRepository localInstance = instance;

        if (localInstance == null) {
            synchronized (PersonRepository.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new GroupRepository();
                }
            }
        }

        return instance;
    }

    @SneakyThrows
    public Optional<List<Group>> getGroupByName(final String name) {
        final int indexByName = getIndexByName(name);
        List<Group> groupList = ENTITY_MANAGER.createNativeQuery("select * from student_group AS g where g.group_name = ?;",
                        Group.class)
                .setParameter(1, indexByName)
                .getResultList();

        return Optional.ofNullable(groupList);
    }

    @SneakyThrows
    public List<StudentGroupDTO> getStudentNumberInGroups() {
        return ENTITY_MANAGER.createQuery(
                "SELECT new com.shulha.model.StudentGroupDTO(g.group, COUNT(s)) " +
                        "FROM Group as g " +
                        "JOIN g.students AS s " +
                        "GROUP BY g.id",
                StudentGroupDTO.class
        ).getResultList();
    }

    @SneakyThrows
    public List<GroupMarkDTO> getAverageMarksFromGroups() {
        return ENTITY_MANAGER.createQuery(
                "SELECT new com.shulha.model.GroupMarkDTO(g.group, ROUND(AVG(m.mark))) " +
                        "FROM Group AS g " +
                        "JOIN g.students AS s " +
                        "JOIN s.marks AS m " +
                        "GROUP BY g.id",
                GroupMarkDTO.class
        ).getResultList();
    }

    @SneakyThrows
    private int getIndexByName(final String name) {
        final int indexByName = Groups.getIndexByName(name);

        if (indexByName < 0) {
            throw new IllegalArgumentException("Such group does not exist!");
        }

        return indexByName;
    }
}
