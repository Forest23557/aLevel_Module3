package com.shulha.builder;

import com.shulha.enums.Groups;
import com.shulha.model.Group;
import com.shulha.model.Student;

import java.util.List;

public interface GroupBuilderInterface {
    GroupBuilderInterface setId(final String id);

    GroupBuilderInterface setGroupValue(final Groups groupValue);

    GroupBuilderInterface setStudents(final List<Student> students);

    GroupBuilderInterface setStudent(final Student student);

    Group getGroup();
}
