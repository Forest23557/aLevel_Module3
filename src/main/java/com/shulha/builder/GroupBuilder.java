package com.shulha.builder;

import com.shulha.enums.Groups;
import com.shulha.model.Group;
import com.shulha.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GroupBuilder {
    private Group group;

    public GroupBuilder() {
        this.group = new Group();
    }

    public GroupBuilder setId(String id) {
        Optional.ofNullable(id)
                .filter(id1 -> !id1.isBlank())
                .ifPresent(id1 -> group.setId(id1));

        return this;
    }

    public GroupBuilder setGroupValue(Groups groupValue) {
        Optional.ofNullable(groupValue)
                .ifPresentOrElse(
                        group1 -> group.setGroup(group1),
                        () -> group.setGroup(Groups.NONE)
                );

        return this;
    }

    public GroupBuilder setStudents(List<Student> students) {
        Optional.ofNullable(students)
                .ifPresentOrElse(
                        students1 -> group.setStudents(students1),
                        () -> createStudentsIfNotExist()
                );

        return this;
    }

    public GroupBuilder setStudent(final Student student) {
        Optional.ofNullable(student)
                .ifPresent(student1 -> {
                    createStudentsIfNotExist();

                    group.getStudents()
                            .add(student1);
                });

        return this;
    }

    public Group getGroup() {
        return group;
    }

    private void createStudentsIfNotExist() {
        if (Objects.isNull(group.getStudents())) {
            group.setStudents(new ArrayList<>());
        }
    }
}
