package com.shulha.builder;

import com.shulha.model.Lecturer;
import com.shulha.model.Subject;

import java.util.Optional;

public class LecturerBuilder extends PersonBuilder<LecturerBuilder> {
    private Lecturer lecturer;

    public LecturerBuilder() {
        super(new Lecturer());
        this.lecturer = (Lecturer) super.getPerson();
    }

    public PersonBuilderInterface setSubject(final Subject subject) {
        Optional.ofNullable(subject)
                .ifPresentOrElse(
                        subject1 -> lecturer.setSubject(subject1),
                        () -> lecturer.setSubject(new Subject())
                );

        return this;
    }

    @Override
    public LecturerBuilder getCertainBuilder() {
        return this;
    }
}
