package com.shulha.builder;

import com.shulha.model.Mark;
import com.shulha.model.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentBuilder extends PersonBuilder<StudentBuilder> {
    private Student student;

    public StudentBuilder() {
        super(new Student());
        this.student = (Student) super.getPerson();
    }

    public PersonBuilderInterface setEntryDateTime(final LocalDateTime entryDateTime) {
        Optional.ofNullable(entryDateTime)
                .ifPresentOrElse(
                        dateTime -> student.setEntryDateTime(dateTime),
                        () -> student.setEntryDateTime(LocalDateTime.now())
                );

        return this;
    }

    public PersonBuilderInterface setMarks(final List<Mark> marks) {
        Optional.ofNullable(marks)
                .ifPresentOrElse(
                        marks1 -> student.setMarks(marks1),
                        () -> createMarksIfNotExist()
                );

        return this;
    }

    public PersonBuilderInterface setMark(final Mark mark) {
        Optional.ofNullable(mark)
                .ifPresent(mark1 -> {
                    createMarksIfNotExist();

                    student.getMarks()
                            .add(mark1);
                });

        return this;
    }

    @Override
    public StudentBuilder getCertainBuilder() {
        return this;
    }

    private void createMarksIfNotExist() {
        if (Objects.isNull(student.getMarks())) {
            student.setMarks(new ArrayList<>());
        }
    }
}
