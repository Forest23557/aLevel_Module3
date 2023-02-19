package com.shulha.builder;

import com.shulha.enums.Groups;
import com.shulha.model.Group;
import com.shulha.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GroupBuilder implements GroupBuilderInterface {
    private Group group;

    public GroupBuilder() {
        this.group = new Group();
    }

    @Override
    public GroupBuilderInterface setId(String id) {
        Optional.ofNullable(id)
                .filter(id1 -> !id1.isBlank())
                .ifPresent(id1 -> group.setId(id1));

        return this;
    }

    @Override
    public GroupBuilderInterface setGroupValue(Groups groupValue) {
        Optional.ofNullable(groupValue)
                .ifPresentOrElse(
                        group1 -> group.setGroup(group1),
                        () -> group.setGroup(Groups.NONE)
                );

        return this;
    }

    @Override
    public GroupBuilderInterface setStudents(List<Student> students) {
        Optional.ofNullable(students)
                .ifPresentOrElse(
                        students1 -> group.setStudents(students1),
                        () -> createStudentsIfNotExist()
                );

        return this;
    }

    @Override
    public GroupBuilderInterface setStudent(final Student student) {
        Optional.ofNullable(student)
                .ifPresent(student1 -> {
                    createStudentsIfNotExist();

                    group.getStudents()
                            .add(student1);
                });

        return this;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    private void createStudentsIfNotExist() {
        if (Objects.isNull(group.getStudents())) {
            group.setStudents(new ArrayList<>());
        }
    }
}
