package com.shulha.model;

import com.shulha.enums.Groups;

import java.util.List;
import java.util.Optional;

public class Group {
    private Groups group;
    private List<Student> students;

    public Group() {
        this.group = Groups.NONE;
    }

    public void setGroup(final Groups group) {
        this.group = Optional.ofNullable(group)
                .orElseGet(() -> Groups.NONE);
    }

    public void setStudents(final List<Student> students) {
        this.students = students;
    }

    public Groups getGroup() {
        return group;
    }

    public List<Student> getStudents() {
        return students;
    }
}
