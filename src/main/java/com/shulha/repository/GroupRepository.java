package com.shulha.repository;

import com.shulha.DTO.StudentGroupDTO;
import com.shulha.config.HibernateFactoryUtil;
import com.shulha.enums.Groups;
import com.shulha.model.Group;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GroupRepository {
    private static final EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();
    private static GroupRepository instance;

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

    public List<Group> getGroupByName(final String name) {
        List<Group> groupList = null;

        if (Objects.nonNull(name) && !name.isBlank()) {
            final int indexByName = Groups.getIndexByName(name);

            try {
                if (indexByName >= 0) {
                    groupList = ENTITY_MANAGER.createNativeQuery("select * from student_group where group_name = ?;",
                                    Group.class)
                            .setParameter(1, indexByName)
                            .getResultList();
                } else {
                    throw new IllegalArgumentException("Such group does not exist!");
                }

            } catch (IllegalStateException ex) {
                ex.printStackTrace();
            } catch (HibernateException ex) {
                ex.printStackTrace();
            }
        }

        return Optional.ofNullable(groupList)
                .orElseGet(ArrayList::new);
    }

    public List<StudentGroupDTO> getStudentNumberInGroups() {
        List<StudentGroupDTO> dtoList = ENTITY_MANAGER.createNativeQuery(
                "SELECT g.group_name, COUNT(*) AS student_number FROM student_group as g " +
                        "LEFT JOIN student AS s ON g.group_id = s.group_id " +
                        "GROUP BY g.group_id;",
                        StudentGroupDTO.class
                ).getResultList();

        return dtoList;
    }

    public static void main(String[] args) {
        final GroupRepository groupRepository = GroupRepository.getInstance();
//        System.out.println(groupRepository.getGroupByName("Ap"));
        System.out.println(groupRepository.getStudentNumberInGroups());
    }
}
