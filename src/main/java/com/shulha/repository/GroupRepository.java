package com.shulha.repository;

import com.shulha.DTO.GroupMarkDTO;
import com.shulha.DTO.StudentGroupDTO;
import com.shulha.config.HibernateFactoryUtil;
import com.shulha.enums.Groups;
import com.shulha.model.Group;
import lombok.SneakyThrows;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        List<Group> groupList = ENTITY_MANAGER.createNativeQuery("select * from student_group where group_name = ?;",
                        Group.class)
                .setParameter(1, indexByName)
                .getResultList();

        return Optional.ofNullable(groupList);
    }

    @SneakyThrows
    public List<StudentGroupDTO> getStudentNumberInGroups() {
        return ENTITY_MANAGER.createNativeQuery(
                "SELECT g.group_name, COUNT(*) AS student_number FROM student_group as g " +
                        "LEFT JOIN student AS s ON g.group_id = s.group_id " +
                        "GROUP BY g.group_id;",
                StudentGroupDTO.class
        ).getResultList();
    }

    @SneakyThrows
    public List<GroupMarkDTO> getAverageMarksFromGroups() {
        return ENTITY_MANAGER.createNativeQuery(
                "SELECT g.group_name, ROUND(AVG(m.mark_value)) AS avg_mark " +
                        "FROM student_group AS g " +
                        "LEFT JOIN student AS s ON g.group_id = s.group_id " +
                        "LEFT JOIN mark AS m ON s.person_id = m.person_id " +
                        "GROUP BY g.group_name;",
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
